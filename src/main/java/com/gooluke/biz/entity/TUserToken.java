package com.gooluke.biz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 咕噜科
 * ClassName: TUserToken
 * date: 2023-08-21 0:46
 * Description:
 * version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TUserToken implements Serializable {

    private Integer id;
    private String userId;
    private String token;
    private String status;
    private String expireTime;
    private String createTime;
    private String updateTime;

}
