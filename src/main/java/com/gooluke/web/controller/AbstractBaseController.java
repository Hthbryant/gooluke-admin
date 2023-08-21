package com.gooluke.web.controller;

import com.gooluke.biz.config.interfaces.TemplateInterface;
import com.gooluke.web.dto.BaseRequestDTO;
import com.gooluke.web.dto.BaseResponseDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 咕噜科
 * ClassName: AbstractBaseController
 * date: 2023-08-21 20:44
 * Description:
 * version 1.0
 */
public class AbstractBaseController extends BaseController{


    @Override
    public <T extends BaseResponseDTO, E extends BaseRequestDTO> T doExecute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, long timeout, E request, TemplateInterface<T, E> templateInterface, T timoutResponse, T exceptionResponse) {
        return super.doExecute(httpServletRequest, httpServletResponse, timeout, request, templateInterface, timoutResponse, exceptionResponse);
    }

    @Override
    protected void preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BaseRequestDTO request, Method method) {
        super.preHandle(httpServletRequest, httpServletResponse, request,method);
    }

    @Override
    protected void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BaseResponseDTO response,Method method) {
        super.postHandle(httpServletRequest, httpServletResponse, response,method);
    }
}
