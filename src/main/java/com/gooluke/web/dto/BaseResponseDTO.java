package com.gooluke.web.dto;

import com.gooluke.common.enums.ErrorStatus;

/**
 * @author 咕噜科
 * ClassName: BaseResponseDTO
 * date: 2023-06-10 14:41
 * Description:
 * version 1.0
 */
public class BaseResponseDTO {

    private String code = "0";
    private String msg = "success";
    private String bizSeqNo;

    private PageInfo page;
    private Object data;


    public BaseResponseDTO() {
    }

    public BaseResponseDTO(Object object) {
        this.code = "0";
        this.msg = "success";
        if (object instanceof BaseResponseDTO) {
            ((BaseResponseDTO) object).setCode(null);
            ((BaseResponseDTO) object).setMsg(null);
        }
        this.data = object;
    }

    public static BaseResponseDTO page(PageInfo page,Object object) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (object instanceof BaseResponseDTO) {
            ((BaseResponseDTO) object).setCode(null);
            ((BaseResponseDTO) object).setMsg(null);
        }
        baseResponseDTO.setPage(page);
        baseResponseDTO.setData(object);
        return baseResponseDTO;
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

    public String getBizSeqNo() {
        return bizSeqNo;
    }

    public void setBizSeqNo(String bizSeqNo) {
        this.bizSeqNo = bizSeqNo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }
}
