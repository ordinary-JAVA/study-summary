package com.example.test.eb.demo.bean;

/**
 * @author lizongren
 * @create 2020.05.07 10:16
 */


import com.example.test.eb.demo.serialize.CustomTimestampDeserializer;
import com.example.test.eb.demo.serialize.CustomTimestampSerializer;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;
import java.util.List;

public class Dag {
    private String dagId;
    private Integer isPaused;
    private Integer isActive;
    @JsonSerialize(using = CustomTimestampSerializer.class)
    @JsonDeserialize(using = CustomTimestampDeserializer.class)
    private Timestamp lastSchedulerRun;
    private String owners;
    private List<DagState> dagState;

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    public void setIsPaused(Integer isPaused) {
        this.isPaused = isPaused;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public void setLastSchedulerRun(Timestamp lastSchedulerRun) {
        this.lastSchedulerRun = lastSchedulerRun == null ? null : (Timestamp) lastSchedulerRun.clone();
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setDagState(List<DagState> dagState) {
        this.dagState = dagState;
    }

    public String getDagId() {
        return dagId;
    }

    public Integer getIsPaused() {
        return isPaused;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public Timestamp getLastSchedulerRun() {
        return lastSchedulerRun == null ? null : (Timestamp) lastSchedulerRun.clone();
    }

    public String getOwners() {
        return owners;
    }

    public List<DagState> getDagState() {
        return dagState;
    }
    @JsonView(DagView.DagTestView.class)
    public String getView(){
        return "test";
    }
}

