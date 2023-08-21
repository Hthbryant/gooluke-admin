package com.gooluke.web.controller;

import com.gooluke.biz.service.UserInfoService;
import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.web.dto.user.UserRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: UserController
 * date: 2023-08-21 20:42
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends GoolukeBaseController{

    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/info/list")
    public BaseResponseDTO selectUserList(HttpServletRequest httpServletRequest,
                                          HttpServletResponse httpServletResponse,
                                          @RequestBody UserRequestDTO requestDTO){

        return doExecute(httpServletRequest,httpServletResponse,timeout,requestDTO,(request->{
            return userInfoService.selectUserList(request);
        }),timeoutResponse,exceptionResponse);
    }

    @RequestMapping("/info/query")
    public BaseResponseDTO queryUserInfo(HttpServletRequest httpServletRequest,
                                          HttpServletResponse httpServletResponse,
                                          @RequestBody UserRequestDTO requestDTO){

        return doExecute(httpServletRequest,httpServletResponse,timeout,requestDTO,(request->{
            return userInfoService.selectById(request);
        }),timeoutResponse,exceptionResponse);
    }

}
