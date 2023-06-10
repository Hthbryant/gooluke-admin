package com.gooluke.web.controller;

import com.gooluke.common.dto.BaseResponseDTO;
import com.gooluke.common.entity.FileData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 咕噜科
 * ClassName: FileController
 * date: 2023-06-10 14:40
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/get")
    public BaseResponseDTO<FileData> getFile(String name) {
        return new BaseResponseDTO<>(new FileData("id-" + name, name));
    }

}
