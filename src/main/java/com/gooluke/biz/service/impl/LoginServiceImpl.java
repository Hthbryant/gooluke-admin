package com.gooluke.biz.service.impl;

import com.gooluke.biz.entity.TUserInfo;
import com.gooluke.biz.entity.TUserToken;
import com.gooluke.biz.integration.dao.UserInfoDAO;
import com.gooluke.biz.integration.dao.UserTokenDAO;
import com.gooluke.biz.service.LoginService;
import com.gooluke.common.enums.ErrorStatus;
import com.gooluke.common.enums.UserTokenStatusEnum;
import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.web.dto.login.LoginRequestDTO;
import com.gooluke.web.dto.login.LoginResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 咕噜科
 * ClassName: LoginServiceImpl
 * date: 2023-08-21 0:57
 * Description:
 * version 1.0
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoDAO userInfoDAO;
    @Autowired
    private UserTokenDAO userTokenDAO;
    @Override
    public BaseResponseDTO login(LoginRequestDTO requestDTO) {
        TUserInfo userInfo = userInfoDAO.selectByUserIdAndPassword(requestDTO.getUserId(), requestDTO.getPassword());
        if (userInfo == null) {
            log.info("用户不存在或密码错误:{}",requestDTO.getUserId());
            return new BaseResponseDTO(ErrorStatus.LOGIN_WRONG);
        }

        //todo 生成登录token
        String token = RandomStringUtils.random(32, "ABCDEF0123456789");
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(15);
        String expireTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
        TUserToken oldUserToken = userTokenDAO.selectByUserId(requestDTO.getUserId());
        TUserToken newUserToken = new TUserToken().setUserId(requestDTO.getUserId()).setToken(token).setExpireTime(expireTime).setStatus(UserTokenStatusEnum.NORMAL.getStatus());

        int result = oldUserToken != null ? userTokenDAO.updateToken(newUserToken) : userTokenDAO.insert(newUserToken);
        if (result == 0) {
            log.warn("生成或更新token失败");
            return new BaseResponseDTO(ErrorStatus.SYSTEM_ERROR);
        }
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setToken(token);
        responseDTO.setExpireTime(expireTime);
        return new BaseResponseDTO(responseDTO);
    }

    @Override
    public BaseResponseDTO logout(LoginRequestDTO requestDTO) {
        TUserToken tUserToken = userTokenDAO.selectByUserId(requestDTO.getUserId());
        if (tUserToken != null) {
            TUserToken update = new TUserToken().setUserId(requestDTO.getUserId()).setStatus(UserTokenStatusEnum.EXPIRED.getStatus());
            userTokenDAO.updateTokenStatus(update);
        }
        return new BaseResponseDTO();
    }
}
