package com.gooluke.web.dto.login;

import com.gooluke.web.dto.BaseRequestDTO;
import lombok.Data;

/**
 * @author 咕噜科
 * ClassName: LoginRequestDTO
 * date: 2023-08-21 0:58
 * Description:
 * version 1.0
 */
@Data
public class LoginRequestDTO extends BaseRequestDTO {

    private String userId;
    private String password;
}
