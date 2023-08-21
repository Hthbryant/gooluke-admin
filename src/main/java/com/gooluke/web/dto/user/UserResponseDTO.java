package com.gooluke.web.dto.user;

import com.gooluke.biz.entity.TUserInfo;
import lombok.Data;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: UserResponseDTO
 * date: 2023-08-21 21:45
 * Description:
 * version 1.0
 */
@Data
public class UserResponseDTO {

    private Integer id;
    private String userId;
    private String userName;
    private String nickName;
    private String password;
    private String address;
    private String phone;
    private String createTime;
    private String updateTime;
    private List<TUserInfo> userInfoList;

}
