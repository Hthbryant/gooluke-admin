package com.gooluke.web.controller;

import com.gooluke.biz.service.LoginService;
import com.gooluke.common.enums.ErrorStatus;
import com.gooluke.web.dto.login.LoginRequestDTO;
import com.gooluke.web.dto.login.LoginResponseDTO;
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
public class LoginController extends BaseController{

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public LoginResponseDTO login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                  @RequestHeader String userId, @RequestHeader String password){
        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setUserId(userId);
        requestDTO.setPassword(password);
        log.info("getPlayerList requestDTO:{}", JSON_MAPPER.toJson(requestDTO));
        LoginResponseDTO timeoutResponse = new LoginResponseDTO(ErrorStatus.TIMEOUT_EXCEPTION);
        LoginResponseDTO errorResponse = new LoginResponseDTO(ErrorStatus.SYSTEM_ERROR);
        return doExecute(httpServletRequest,httpServletResponse,timeout,requestDTO,(request->{
            LoginResponseDTO responseDTO = loginService.login(request);
            log.info("login responseDTO:{}", JSON_MAPPER.toJson(responseDTO));
            return responseDTO;
        }),timeoutResponse,errorResponse);
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout success";
    }

}
