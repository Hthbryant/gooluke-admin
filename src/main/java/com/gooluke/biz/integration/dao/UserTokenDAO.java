package com.gooluke.biz.integration.dao;

import com.gooluke.biz.entity.TUserToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 咕噜科
 * ClassName: UserInfoDAO
 * date: 2023-08-21 0:47
 * Description:
 * version 1.0
 */
@Mapper
public interface UserTokenDAO {

    TUserToken selectByUserIdAndToken(@Param("userId") String userId, @Param("token") String token);

    TUserToken selectByUserId(@Param("userId") String userId);

    int insert(TUserToken userToken);

    int updateToken(TUserToken userToken);

    int updateTokenStatus(TUserToken userToken);
}
