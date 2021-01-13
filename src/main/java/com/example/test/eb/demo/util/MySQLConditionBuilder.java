package com.example.test.eb.demo.util;

import com.example.test.eb.demo.bean.QueryEntity;
import com.example.test.eb.demo.enumdata.FieldTypeEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MySQLConditionBuilder {

    public static String generate(QueryEntity entity, FieldTypeEnum fieldType, String paramName, int postion) {
        if (checkParamters(entity)) return " 1=1 ";
        StringBuilder con = new StringBuilder();
        switch (entity.getFilter()) {
            case EMPTY:
                con.append(entity.getField()).append(" is null");
                break;
            case NOT_EMPTY:
                con.append(entity.getField()).append(" is not null");
                break;
            case EQUALS:
                con.append(entity.getField()).append(" = ").append(conditionA(paramName, postion));
                break;
            case NOT_EQUAL:
                con.append(entity.getField()).append(" != ").append(conditionA(paramName, postion));
                break;
            case NOT_BETWEEN:
                con.append(entity.getField()).append(" not between ")
                        .append(conditionA(paramName, postion))
                        .append(" and ")
                        .append(conditionB(paramName, postion));
                break;
            case BETWEEN:
                con.append(entity.getField()).append(" between ")
                        .append(conditionA(paramName, postion))
                        .append(" and ")
                        .append(conditionB(paramName, postion));
                break;
            case GREATER_THAN:
                con.append(entity.getField()).append(" > ").append(conditionA(paramName, postion));
                break;
            case SMALLER_THAN:
                con.append(entity.getField()).append(" < ").append(conditionA(paramName, postion));
                break;
            case NOT_CONTAINS:
                con.append(entity.getField()).append(" not like CONCAT('%',").append(conditionA(paramName, postion)).append(",'%')");
                break;
            case CONTAINS:
                con.append(entity.getField()).append(" like CONCAT('%',").append(conditionA(paramName, postion)).append(",'%')");
                break;
            case NOT_IN_LIST:
                con.append(entity.getField()).append(" not in (")
                        .append(Arrays.stream(entity.getValueA().split(","))
                                .map(value -> subConditionByFilter(fieldType, value, entity.getFormat()))
                                .collect(Collectors.joining(",")))
                        .append(")");
                break;
            case IN_LIST:
                con.append(entity.getField()).append(" in (")
                        .append(Arrays.stream(entity.getValueA().split(","))
                                .map(value -> subConditionByFilter(fieldType, value, entity.getFormat()))
                                .collect(Collectors.joining(",")))
                        .append(")");
                break;
            default:
                con.append(" 1=1 ");
                break;
        }
        return con.toString();
    }

    private static boolean checkParamters(QueryEntity entity) {
        return entity.getField() == null || entity.getField().isEmpty() || entity.getFilter() == null;
    }

    private static String conditionA(String paramName, int postion) {
        return "#{" + paramName + "[" + postion + "].valueA}";
    }

    private static String conditionB(String paramName, int postion) {
        return "#{" + paramName + "[" + postion + "].valueB}";
    }

    private static String subConditionByFilter(FieldTypeEnum fieldType, String value, String format) {
        if (value == null || value.isEmpty()) return "''";
        switch (fieldType) {
            case STRING:
                value = value.replace("'", "\\'");
                return "'" + value + "'";
            case NUMBER:
                try {
                    Double.parseDouble(value);
                } catch (NumberFormatException e) {
                    return "";
                }
                return value;
            case DATETIME:
                value = value.replace("'", "\\'");
                if (format == null || format.isEmpty()) {
                    return "'" + value + "'";
                }
                return "str_to_date('" + value + "','" + format + "')";
            default:
                return "";
        }
    }
}
