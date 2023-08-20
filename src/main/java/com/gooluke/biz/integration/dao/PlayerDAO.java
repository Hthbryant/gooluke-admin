package com.gooluke.biz.integration.dao;

import com.gooluke.biz.entity.TPlayer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: PlayerDAO
 * date: 2023-08-20 17:14
 * Description:
 * version 1.0
 */
@Mapper//这里不加也行，不影响注入，加了自动注入就不会报红
public interface PlayerDAO {

    TPlayer selectById(@Param("id") Integer id);
    List<TPlayer> selectPlayerList(TPlayer player);
}
