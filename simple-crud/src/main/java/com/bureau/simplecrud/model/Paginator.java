package com.bureau.simplecrud.model;

import java.util.List;

public class Paginator<T> {

    private Integer sizeList;
    private Integer pageSize;
    private Integer previousPage;
    private Integer currentPage;
    private Integer nextPage;
    private List<T> list;

    public Integer getSizeList() {
        return sizeList;
    }

    public void setSizeList(Integer sizeList) {
        this.sizeList = sizeList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Integer previousPage) {
        this.previousPage = previousPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
