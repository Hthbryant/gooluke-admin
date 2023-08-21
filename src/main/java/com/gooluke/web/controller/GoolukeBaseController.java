package com.gooluke.web.controller;

import com.gooluke.common.tool.JsonMapper;
import com.gooluke.web.dto.BaseRequestDTO;
import com.gooluke.web.dto.BaseResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 咕噜科
 * ClassName: GoolukeBaseController
 * date: 2023-08-21 20:49
 * Description:
 * version 1.0
 */
public class GoolukeBaseController extends AbstractBaseController{

    protected static final Logger logger = LoggerFactory.getLogger(GoolukeBaseController.class);
    protected static final JsonMapper JSON_MAPPER = JsonMapper.nonEmptyMapper();

    protected static long timeout = 7000;
    @Override
    protected void preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BaseRequestDTO request, Method method) {
        //统一请求日志打印
        logger.info("{}.{} request:{}",method.getDeclaringClass().getSimpleName(),method.getName(),JSON_MAPPER.toJson(request));
    }

    @Override
    protected void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BaseResponseDTO response) {
        logger.info("postHandle...");
    }
}
