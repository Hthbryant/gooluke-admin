package com.gooluke.common.exception;

import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.common.enums.ErrorStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: GlobalExceptionHandler
 * date: 2023-08-16 0:11
 * Description:
 * version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    //全局异常处理
    @ExceptionHandler(Exception.class)
    public BaseResponseDTO handleException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception e) {
        log.warn(String.format("请求[%s]异常: [%s]", httpServletRequest.getRequestURI(), e.getMessage()));
        return new BaseResponseDTO(ErrorStatus.SYSTEM_ERROR);
    }

    //捕获必传header导致的异常
    @ExceptionHandler(MissingRequestHeaderException.class)
    public BaseResponseDTO handleMissingRequestHeaderException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, MissingRequestHeaderException e) {
        String errMsg = String.format("请求 %s 缺少请求头 [%s]", httpServletRequest.getRequestURI(), e.getHeaderName());
        log.warn(errMsg);
        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new BaseResponseDTO(ErrorStatus.WRONG_PARAM.getErrCode(), errMsg);
    }

}
