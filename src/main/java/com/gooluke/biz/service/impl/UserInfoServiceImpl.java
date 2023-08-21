package com.gooluke.biz.service.impl;

import com.gooluke.biz.entity.TUserInfo;
import com.gooluke.biz.integration.dao.UserInfoDAO;
import com.gooluke.biz.service.UserInfoService;
import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.web.dto.PageInfo;
import com.gooluke.web.dto.user.UserRequestDTO;
import com.gooluke.web.dto.user.UserResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: UserInfoServiceImpl
 * date: 2023-08-21 21:48
 * Description:
 * version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;


    @Override
    public BaseResponseDTO selectUserList(UserRequestDTO requestDTO) {
        TUserInfo userInfo = new TUserInfo();
        BeanUtils.copyProperties(requestDTO, userInfo);
        userInfo.setPage(requestDTO.getPage() != null ? requestDTO.getPage() : new PageInfo());
        List<TUserInfo> tUserInfos = userInfoDAO.selectUserList(userInfo);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserInfoList(tUserInfos);
        return new BaseResponseDTO(userResponseDTO);
    }

    @Override
    public BaseResponseDTO selectById(UserRequestDTO requestDTO) {
        TUserInfo userInfo = userInfoDAO.selectById(requestDTO.getId());
        if (userInfo == null) {
            //
            return new BaseResponseDTO();
        } else {
            UserResponseDTO responseDTO = new UserResponseDTO();
            BeanUtils.copyProperties(userInfo, responseDTO);
            return new BaseResponseDTO(responseDTO);
        }

    }
}
