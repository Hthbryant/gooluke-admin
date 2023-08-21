package com.gooluke.biz.service;

import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.web.dto.user.UserRequestDTO;

/**
 * @author 咕噜科
 * ClassName: UserInfoService
 * date: 2023-08-21 21:47
 * Description:
 * version 1.0
 */
public interface UserInfoService {

    BaseResponseDTO selectUserList(UserRequestDTO requestDTO);

    BaseResponseDTO selectById(UserRequestDTO requestDTO);

}
