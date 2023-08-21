package com.gooluke.biz.service.impl;

import com.gooluke.biz.entity.TUserToken;
import com.gooluke.biz.integration.dao.UserTokenDAO;
import com.gooluke.biz.service.AuthService;
import com.gooluke.common.enums.UserTokenStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 咕噜科
 * ClassName: AuthServiceImpl
 * date: 2023-08-21 23:09
 * Description:
 * version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    public final static String COOKIE_TOKEN = "token";
    public final static String COOKIE_USER_ID = "userId";

    @Autowired
    private UserTokenDAO userTokenDAO;


    @Override
    public boolean checkToken(HttpServletRequest request) {
        String token = getTokenFromCookie(request);
        if (StringUtils.isEmpty(token)) {
            return false;
        }

        String userId = getUserIdFromCookie(request);
        if (StringUtils.isEmpty(userId)) {
            return false;
        }

        //todo 为了方便接口测试，万能token
        if ("bryant".equals(token)) {
            return true;
        }

        TUserToken userToken = userTokenDAO.selectByUserId(userId);
        if (userToken == null || !UserTokenStatusEnum.NORMAL.getStatus().equals(userToken.getStatus()) || !StringUtils.equals(token, userToken.getToken()) ||isExpireToken(userToken.getExpireTime())) {
            logger.warn("token is invalid");
            return false;
        }

        //有请求过来，并且token正确，则对该token续有效期15分钟
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(15);
        String expireTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
        userTokenDAO.update(new TUserToken().setUserId(userId).setToken(token).setExpireTime(expireTime));
        return true;
    }

    private boolean isExpireToken (String expireTime) {
        LocalDateTime expireDateTime = LocalDateTime.parse(expireTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return expireDateTime.isBefore(LocalDateTime.now());
    }
    @Override
    public String getTokenFromCookie(HttpServletRequest request) {
        return getCookieValue(request, COOKIE_TOKEN);
    }

    @Override
    public String getUserIdFromCookie(HttpServletRequest request) {
        return getCookieValue(request, COOKIE_USER_ID);
    }

    private String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (request.getCookies() == null || request.getCookies().length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return  cookie.getValue();
            }
        }
        return null;
    }


}
