package com.gooluke.biz.service.impl;

import com.gooluke.biz.integration.dao.PlayerDAO;
import com.gooluke.biz.service.PlayerService;
import com.gooluke.biz.entity.TPlayer;
import com.gooluke.web.dto.PageInfo;
import com.gooluke.web.dto.player.PlayerRequestDTO;
import com.gooluke.web.dto.player.PlayerResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: PlayerServiceImpl
 * date: 2023-08-18 20:53
 * Description:
 * version 1.0
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;
    @Override
    public PlayerResponseDTO getPlayerList(PlayerRequestDTO requestDTO) {
        TPlayer player = new TPlayer();
        BeanUtils.copyProperties(requestDTO,player);
        PageInfo page = requestDTO.getPage() == null ? new PageInfo() : requestDTO.getPage();
        player.setPage(page);
        List<TPlayer> list = playerDAO.selectPlayerList(player);
        PlayerResponseDTO responseDTO = new PlayerResponseDTO();
        responseDTO.setPlayerList(list);
        return responseDTO;
    }
}
