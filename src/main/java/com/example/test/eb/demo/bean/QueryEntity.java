package com.example.test.eb.demo.bean;


import com.example.test.eb.demo.enumdata.FieldTypeEnum;
import com.example.test.eb.demo.util.MySQLConditionBuilder;
import com.example.test.eb.demo.enumdata.QueryFilterEnum;

public class QueryEntity {

    private String field;
    private QueryFilterEnum filter;
    private String valueA;
    private String valueB;
    private String format;

    private QueryEntity() {
    }

    public String getField() {
        return field;
    }

    public QueryFilterEnum getFilter() {
        return filter;
    }

    public String getValueA() {
        return valueA;
    }

    public String getValueB() {
        return valueB;
    }

    public static QueryEntity newInstance() {
        return new QueryEntity();
    }

    public QueryEntity setField(String field) {
        this.field = field;
        return this;
    }

    public QueryEntity setValueA(String valueA) {
        this.valueA = valueA;
        return this;
    }

    public QueryEntity setFilter(QueryFilterEnum filter) {
        this.filter = filter;
        return this;
    }

    public QueryEntity setValueB(String valueB) {
        this.valueB = valueB;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String condition(String paramName, int postion, FieldTypeEnum fieldType) {
        return MySQLConditionBuilder.generate(this, fieldType, paramName, postion);
    }
}
