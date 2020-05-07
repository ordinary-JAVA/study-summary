package com.example.test.rest;

import java.util.List;

public class PageList<T> {
    private int currentPage;
    private int count;
    private List<T> rows;

    public PageList() {}

    public PageList(List<T> rows, int currentPage, int count) {
        this.rows = rows;
        this.currentPage = currentPage;
        this.count = count;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getCount() {
        return this.count;
    }
}