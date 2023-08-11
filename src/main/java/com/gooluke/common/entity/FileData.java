package com.gooluke.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 咕噜科
 * ClassName: FileData
 * date: 2023-06-10 15:25
 * Description:
 * version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FileData {

    private String fileId;
    private String fileName;

}
