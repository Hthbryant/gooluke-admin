package com.gooluke.web.dto.player;

import com.gooluke.web.dto.BaseRequestDTO;
import com.gooluke.web.dto.PageInfo;
import lombok.Data;

/**
 * @author 咕噜科
 * ClassName: PlayerRequestDTO
 * date: 2023-08-18 20:51
 * Description:
 * version 1.0
 */
@Data
public class PlayerRequestDTO extends BaseRequestDTO {

    private Integer id;
    private String name;
    private String phone;
    private String address;

    private PageInfo page;

}
