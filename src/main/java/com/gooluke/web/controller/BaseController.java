package com.gooluke.web.controller;

import com.gooluke.biz.config.interfaces.TemplateInterface;
import com.gooluke.common.utils.BizSeqUtil;
import com.gooluke.web.dto.BaseRequestDTO;
import com.gooluke.web.dto.BaseResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author 咕噜科
 * ClassName: BaseController
 * date: 2023-08-18 20:32
 * Description: BaseController 和 AbstractController 作为sdk提供的
 * 基础控制器，提供基础的请求处理，日志记录，返回处理，异常处理等,不能做修改，只能在继承类中添加自己的业务逻辑
 * 例如 preHandle 方法，postHandle 方法，afterCompletion 方法，这些方法都是可以被重写的
 * version 1.0
 */
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    @Qualifier("threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    @Qualifier("requestMappingHandlerMapping")
    private RequestMappingHandlerMapping handlerMapping;

    @Autowired
    private BizSeqUtil bizSeqUtil;

    public <T extends BaseResponseDTO, E extends BaseRequestDTO> T doExecute(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, long timeout, E request, TemplateInterface<T, E> templateInterface, T timoutResponse, T exceptionResponse) {
        //TODO 执行逻辑
        setBizSeq(request);
        try {


            HandlerExecutionChain handler = this.getHandlerMapping().getHandler(httpServletRequest);
            HandlerMethod handlerMethod = (HandlerMethod) handler.getHandler();
            Method method = handlerMethod.getMethod();

            preHandle(httpServletRequest,httpServletResponse,request,method);

            Future<T> future = threadPoolTaskExecutor.submit(() -> {
                return templateInterface.apply(request);
            });
            T baseResponseDTO = future.get(timeout, TimeUnit.MILLISECONDS);
            baseResponseDTO.setBizSeqNo(request.getBizSeqNo());
            postHandle(httpServletRequest,httpServletResponse,baseResponseDTO,method);
            return baseResponseDTO;
        } catch (TimeoutException e) {
            logger.error("{}|submit request timeout exception:{}",request.getBizSeqNo(),e.getMessage());
            timoutResponse.setBizSeqNo(request.getBizSeqNo());
            return timoutResponse;
        } catch (Exception e) {
            logger.error("{}|submit request error:",request.getBizSeqNo(),e);
            exceptionResponse.setBizSeqNo(request.getBizSeqNo());
            return exceptionResponse;
        }
    }

    private <E extends BaseRequestDTO> void setBizSeq(E req) {
        if (req.getBizSeqNo() != null && req.getBizSeqNo().length() > 0) {
            return;
        }
        String bizSeqNo = bizSeqUtil.newBizSeq();
        req.setBizSeqNo(bizSeqNo);
    }

    protected void preHandle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,BaseRequestDTO request,Method method) {
        //doSomething before handle request
    }

    protected void postHandle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,BaseResponseDTO response,Method method)  {
        //doSomething after handle request
    }

    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        return threadPoolTaskExecutor;
    }

    public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    public RequestMappingHandlerMapping getHandlerMapping() {
        return handlerMapping;
    }

    public void setHandlerMapping(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }
}
