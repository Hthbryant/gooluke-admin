package com.gooluke.biz.service;

import com.gooluke.web.dto.BaseResponseDTO;
import com.gooluke.web.dto.player.PlayerRequestDTO;

/**
 * @author 咕噜科
 * ClassName: PlayerService
 * date: 2023-08-18 20:53
 * Description:
 * version 1.0
 */
public interface PlayerService {

    BaseResponseDTO getPlayerList(PlayerRequestDTO requestDTO);
}
