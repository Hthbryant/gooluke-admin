package com.gooluke.web.dto.user;

import com.gooluke.web.dto.BaseRequestDTO;
import lombok.Data;

/**
 * @author 咕噜科
 * ClassName: UserRequestDTO
 * date: 2023-08-21 21:33
 * Description:
 * version 1.0
 */
@Data
public class UserRequestDTO extends BaseRequestDTO {

    private Integer id;
    private String userId;
    private String userName;
    private String nickName;
    private String password;
    private String address;
    private String phone;

}
