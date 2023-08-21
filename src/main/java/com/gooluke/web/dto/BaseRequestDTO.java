package com.gooluke.web.dto;

/**
 * @author 咕噜科
 * ClassName: BaseRequestDTO
 * date: 2023-06-10 14:41
 * Description:
 * version 1.0
 */
public class BaseRequestDTO {

    private String bizSeqNo;
    private String opUserId;

    private PageInfo page;

    public String getBizSeqNo() {
        return bizSeqNo;
    }

    public void setBizSeqNo(String bizSeqNo) {
        this.bizSeqNo = bizSeqNo;
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }
}
