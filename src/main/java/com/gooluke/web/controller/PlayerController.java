package com.gooluke.web.controller;

import com.gooluke.biz.service.PlayerService;
import com.gooluke.web.dto.player.PlayerRequestDTO;
import com.gooluke.web.dto.player.PlayerResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: PlayerController
 * date: 2023-08-18 20:48
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/player")
@Slf4j
public class PlayerController extends BaseController{

    @Autowired
    private PlayerService playerService;

    //@RequestCheck
    @RequestMapping("/list")
    public PlayerResponseDTO getPlayerList(HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse,
                                           @RequestBody PlayerRequestDTO requestDTO){
        log.info("getPlayerList requestDTO:{}",JSON_MAPPER.toJson(requestDTO));
        return doExecute(httpServletRequest,httpServletResponse,timeout,requestDTO,(request -> {
            PlayerResponseDTO responseDTO = playerService.getPlayerList(request);
            log.info("getPlayerList responseDTO:{}",responseDTO);
            return responseDTO;
        }));
    }
}
