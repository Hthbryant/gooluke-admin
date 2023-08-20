package com.gooluke.web.dto;

/**
 * @author 咕噜科
 * ClassName: PageInfo
 * date: 2023-08-12 1:04
 * Description:
 * version 1.0
 */
public class PageInfo {

    private int currentPage = 1;
    private int pageSize = 10;

    private int totalPage = 0;
    private int totalCount = 0;

    public PageInfo() {}
    public PageInfo(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
