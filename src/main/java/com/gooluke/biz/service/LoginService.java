package com.gooluke.biz.service;

import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.web.dto.login.LoginRequestDTO;

/**
 * @author 咕噜科
 * ClassName: LoginService
 * date: 2023-08-21 0:57
 * Description:
 * version 1.0
 */
public interface LoginService {

    BaseResponseDTO login (LoginRequestDTO requestDTO);

    BaseResponseDTO logout(LoginRequestDTO requestDTO);

}
