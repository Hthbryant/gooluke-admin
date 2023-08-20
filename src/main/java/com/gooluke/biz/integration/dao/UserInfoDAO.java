package com.gooluke.biz.integration.dao;

import com.gooluke.biz.entity.TUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: UserInfoDAO
 * date: 2023-08-21 0:50
 * Description:
 * version 1.0
 */
@Mapper
public interface UserInfoDAO {

    TUserInfo selectByUserIdAndPassword(@Param("userId") String userId,@Param("password") String password);
    TUserInfo selectById(@Param("id") Integer id);

    List<TUserInfo> selectUserList(TUserInfo userInfo);

}
