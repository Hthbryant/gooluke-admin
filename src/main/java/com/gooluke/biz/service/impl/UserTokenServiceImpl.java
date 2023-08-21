package com.gooluke.biz.service.impl;

import com.gooluke.biz.integration.dao.UserTokenDAO;
import com.gooluke.biz.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 咕噜科
 * ClassName: UserTokenServiceImpl
 * date: 2023-08-21 21:48
 * Description:
 * version 1.0
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    private UserTokenDAO userTokendao;

}
