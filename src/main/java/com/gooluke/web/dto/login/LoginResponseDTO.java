package com.gooluke.web.dto.login;

import com.gooluke.common.enums.ErrorStatus;
import com.gooluke.web.dto.BaseResponseDTO;
import lombok.Data;

/**
 * @author 咕噜科
 * ClassName: LoginResponseDTO
 * date: 2023-08-21 0:58
 * Description:
 * version 1.0
 */

@Data
public class LoginResponseDTO extends BaseResponseDTO {

    private String userId;
    private String token;
    private String expireTime;

    public LoginResponseDTO() {

    }

    public LoginResponseDTO(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
