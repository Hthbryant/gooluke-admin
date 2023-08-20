package com.gooluke.web.controller;

import com.gooluke.common.interfaces.TemplateInterface;
import com.gooluke.common.tool.JsonMapper;
import com.gooluke.common.utils.BizSeqUtil;
import com.gooluke.web.dto.BaseRequestDTO;
import com.gooluke.web.dto.BaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author 咕噜科
 * ClassName: BaseController
 * date: 2023-08-18 20:32
 * Description:
 * version 1.0
 */
public class BaseController {

    protected static final JsonMapper JSON_MAPPER = JsonMapper.nonEmptyMapper();

    @Autowired
    @Qualifier("threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private BizSeqUtil bizSeqUtil;
    protected static long timeout = 7000;


    public <T extends BaseResponseDTO, E extends BaseRequestDTO> T doExecute(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, long timeout, E request, TemplateInterface<T, E> templateInterface, T timoutResponse, T exceptionResponse) {
        //TODO 执行逻辑
        setBizSeq(request);
        Future<BaseResponseDTO> future = getResult(templateInterface, request);
        try {
            future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            return timoutResponse;
        } catch (Exception e) {
            return exceptionResponse;
        }
        T resp = templateInterface.apply(request);
        resp.setBizSeqNo(request.getBizSeqNo());
        return resp;
    }

    public <T extends BaseResponseDTO, E extends BaseRequestDTO> Future<BaseResponseDTO> getResult(TemplateInterface<T, E> templateInterface, E request) {
        return threadPoolTaskExecutor.submit(() -> {
            return templateInterface.apply(request);
        });
    }

    private <E extends BaseRequestDTO> void setBizSeq(E req) {
        if (req.getBizSeqNo() != null && req.getBizSeqNo().length() > 0) {
            return;
        }
        String bizSeqNo = bizSeqUtil.newBizSeq();
        req.setBizSeqNo(bizSeqNo);
    }
}
