package com.gooluke.web.dto.player;

import com.gooluke.biz.entity.TPlayer;
import com.gooluke.web.dto.BaseResponseDTO;
import lombok.Data;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: PlayerResponseDTO
 * date: 2023-08-18 20:58
 * Description:
 * version 1.0
 */
@Data
public class PlayerResponseDTO extends BaseResponseDTO {

    private List<TPlayer> playerList;

    public PlayerResponseDTO() {
    }
}
