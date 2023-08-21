package com.gooluke.biz.entity;

import com.gooluke.web.dto.PageInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 咕噜科
 * ClassName: TUserInfo
 * date: 2023-08-21 0:44
 * Description:
 * version 1.0
 */
@Data
public class TUserInfo implements Serializable {

    private Integer id;
    private String userId;
    private String userName;
    private String nickName;
    private String password;
    private String address;
    private String createTime;
    private String updateTime;

    private PageInfo page;

}
