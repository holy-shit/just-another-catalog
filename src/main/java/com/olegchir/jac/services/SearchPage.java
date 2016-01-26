package com.olegchir.jac.services;

/**
 * Created by olegchir on 26/01/16.
 */
public class SearchPage {
    private int page;
    private int size;

    public SearchPage(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
