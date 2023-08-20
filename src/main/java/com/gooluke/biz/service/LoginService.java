package com.gooluke.biz.service;

import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.web.dto.login.LoginRequestDTO;
import com.gooluke.web.dto.login.LoginResponseDTO;

/**
 * @author 咕噜科
 * ClassName: LoginService
 * date: 2023-08-21 0:57
 * Description:
 * version 1.0
 */
public interface LoginService {

    LoginResponseDTO login (LoginRequestDTO requestDTO);

    BaseResponseDTO logout(LoginRequestDTO requestDTO);

}
