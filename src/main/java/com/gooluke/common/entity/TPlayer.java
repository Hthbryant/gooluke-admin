package com.gooluke.common.entity;

import com.gooluke.web.dto.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 咕噜科
 * ClassName: TPlayer
 * date: 2023-08-18 20:54
 * Description:
 * version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TPlayer implements Serializable {

    private Integer id;
    private String name;
    private String phone;
    private String address;

    private PageInfo page;
}
