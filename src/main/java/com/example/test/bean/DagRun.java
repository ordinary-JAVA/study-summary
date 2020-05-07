package com.example.test.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;

public class DagRun {

    private Long id;
    private String dagId;
    @JsonSerialize(using = CustomTimestampSerializer.class)
    @JsonDeserialize(using = CustomTimestampDeserializer.class)
    private Timestamp executionDate;
    private DagRunState state;
    @JsonSerialize(using = CustomTimestampSerializer.class)
    @JsonDeserialize(using = CustomTimestampDeserializer.class)
    private Timestamp startDate;
    @JsonSerialize(using = CustomTimestampSerializer.class)
    @JsonDeserialize(using = CustomTimestampDeserializer.class)
    private Timestamp endDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    public void setExecutionDate(Timestamp executionDate) {
        this.executionDate = executionDate == null ? null : (Timestamp) executionDate.clone();
    }

    public void setState(DagRunState state) {
        this.state = state;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate == null ? null : (Timestamp) startDate.clone();
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate == null ? null : (Timestamp) endDate.clone();
    }

    public Long getId() {
        return id;
    }

    public String getDagId() {
        return dagId;
    }

    public Timestamp getExecutionDate() {
        return executionDate == null ? null : (Timestamp) executionDate.clone();
    }

    public DagRunState getState() {
        return state;
    }

    public Timestamp getStartDate() {
        return startDate == null ? null : (Timestamp) startDate.clone();
    }

    public Timestamp getEndDate() {
        return endDate == null ? null : (Timestamp) endDate.clone();
    }
}
