package com.gooluke.common.dto;

import com.gooluke.common.enums.ErrorStatus;

/**
 * @author 咕噜科
 * ClassName: BaseResponseDTO
 * date: 2023-06-10 14:41
 * Description:
 * version 1.0
 */
public class BaseResponseDTO<T> {

    private String code = "0";
    private String msg = "success";
    private T data;

    public BaseResponseDTO() {
    }

    public BaseResponseDTO(T t) {
        this.code = "0";
        this.msg = "success";
        this.data = t;
    }

    public BaseResponseDTO(ErrorStatus errorStatus) {
        this.code = errorStatus.getErrCode();
        this.msg = errorStatus.getErrMsg();
    }

    public BaseResponseDTO(String code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
