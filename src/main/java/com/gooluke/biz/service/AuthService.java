package com.gooluke.biz.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 咕噜科
 * ClassName: AuthService
 * date: 2023-08-21 23:09
 * Description:
 * version 1.0
 */
public interface AuthService {

    boolean checkToken(HttpServletRequest request);

    String getTokenFromCookie(HttpServletRequest request);
    String getUserIdFromCookie(HttpServletRequest request);

}
