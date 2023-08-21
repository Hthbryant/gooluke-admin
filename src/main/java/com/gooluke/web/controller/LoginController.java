package com.gooluke.web.controller;

import com.gooluke.biz.service.LoginService;
import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.web.dto.login.LoginRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: LoginController
 * date: 2023-08-15 23:17
 * Description:
 * version 1.0
 */
@RestController
@Slf4j
public class LoginController extends GoolukeBaseController{

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public BaseResponseDTO login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                  @RequestHeader String userId, @RequestHeader String password){
        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setUserId(userId);
        requestDTO.setPassword(password);
        log.info("login requestDTO:{}", JSON_MAPPER.toJson(requestDTO));
        return doExecute(httpServletRequest,httpServletResponse,timeout,requestDTO,(request->{
            BaseResponseDTO responseDTO = loginService.login(request);
            log.info("login responseDTO:{}", JSON_MAPPER.toJson(responseDTO));
            return responseDTO;
        }),timeoutResponse,exceptionResponse);
    }

    @RequestMapping("/logout")
    public BaseResponseDTO logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                  @RequestHeader String userId) {
        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setUserId(userId);
        return doExecute(httpServletRequest, httpServletResponse, timeout, requestDTO, (request -> {
            return loginService.logout(request);
        }), timeoutResponse, exceptionResponse);
    }

}
