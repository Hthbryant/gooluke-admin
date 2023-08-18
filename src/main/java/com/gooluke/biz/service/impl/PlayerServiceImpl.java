package com.gooluke.biz.service.impl;

import com.gooluke.biz.service.PlayerService;
import com.gooluke.common.entity.TPlayer;
import com.gooluke.web.dto.player.PlayerRequestDTO;
import com.gooluke.web.dto.player.PlayerResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 咕噜科
 * ClassName: PlayerServiceImpl
 * date: 2023-08-18 20:53
 * Description:
 * version 1.0
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Override
    public PlayerResponseDTO getPlayerList(PlayerRequestDTO requestDTO) {
        TPlayer tPlayer1 = new TPlayer().setName("kobe").setAddress("美国洛杉矶");
        TPlayer tPlayer2 = new TPlayer().setName("wade").setAddress("美国迈阿密");
        ArrayList<TPlayer> list = new ArrayList<>();
        list.add(tPlayer1);
        list.add(tPlayer2);
        PlayerResponseDTO responseDTO = new PlayerResponseDTO();
        responseDTO.setPlayerList(list);
        return responseDTO;
    }
}
