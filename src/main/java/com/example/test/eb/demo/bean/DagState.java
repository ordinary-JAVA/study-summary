package com.example.test.eb.demo.bean;

public class DagState {

    private String dagId;
    private DagRunState state;
    private Integer count;

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    public void setState(DagRunState state) {
        this.state = state;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDagId() {
        return dagId;
    }

    public DagRunState getState() {
        return state;
    }

    public Integer getCount() {
        return count;
    }
}
