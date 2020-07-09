package com.background.demo.entity;

import org.springframework.stereotype.Component;

@Component()
public class Page {
    private String query;
    private int  pagenum;
    private int  pagesize;

    public void setQuery(String query) {
        this.query = query;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getQuery() {
        return query;
    }

    public int getPagenum() {
        return pagenum;
    }

    public int getPagesize() {
        return pagesize;
    }
}
