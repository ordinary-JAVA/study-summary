package com.example.test.eb.demo.mapper;


import com.google.common.base.Strings;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class DagSqlBuilder {

    public static String buildGetDagInfoList(@Param("queryEntities") List<QueryEntity> queryEntities,
                                             @Param("ownerCode") String ownerCode,
                                             @Param("creator") String creator,
                                             @Param("currentPage") int currentPage,
                                             @Param("numberPerPage") int numberPerPage,
                                             @Param("indexOrderKey") String indexOrderKey,
                                             @Param("indexOrder") String indexOrder) {
        StringBuilder result = new StringBuilder(buildGetDagInfo(false, queryEntities, ownerCode, creator));
        if (indexOrderKey != null && !indexOrderKey.isEmpty()) {
            result.append(" ORDER BY ").append(indexOrderKey);
            if ("ASC".equalsIgnoreCase(indexOrder) || "DESC".equalsIgnoreCase(indexOrder)) {
                result.append(" ").append(indexOrder);
            }
        }
        if (currentPage >= 0)
            result.append(" LIMIT ").append(currentPage * numberPerPage).append(",").append(numberPerPage);
        return result.toString();
    }

    public static String buildGetDagInfoCount(@Param("queryEntities") List<QueryEntity> queryEntities,
                                              @Param("ownerCode") String ownerCode,
                                              @Param("creator") String creator) {
        return buildGetDagInfo(true, queryEntities, ownerCode, creator);
    }

    private static String buildGetDagInfo(boolean getCount,
                                          List<QueryEntity> queryEntities,
                                          String ownerCode,
                                          String creator) {
        return new SQL() {{
            if (getCount) SELECT("count(1)");
            else {
                SELECT("dag_id");
                SELECT("is_paused");
                SELECT("is_active");
                SELECT("last_scheduler_run");
                SELECT("owners");
            }
            FROM("dag");
            if (queryEntities != null)
                for (int i = 0; i < queryEntities.size(); i++) {
                    QueryEntity query = queryEntities.get(i);
                    switch (query.getField()) {
                        case "dag_id":
                        case "owners":
                            WHERE(query.condition(BuilderConstants.QUERY_ENTITIES, i, FieldType.STRING));
                            break;
                        case "is_active":
                        case "is_paused":
                            WHERE(query.condition(BuilderConstants.QUERY_ENTITIES, i, FieldType.NUMBER));
                            break;
                        case "last_scheduler_run":
                            WHERE(query.condition(BuilderConstants.QUERY_ENTITIES, i, FieldType.DATETIME));
                            break;
                        default:
                            break;
                    }
                }
            if (!Strings.isNullOrEmpty(ownerCode)) {
                if (!Strings.isNullOrEmpty(creator))
                    WHERE("dag_id in (select dag_id from idox_owner_dag where owner_code = #{ownerCode} and creator = #{creator})");
                else
                    WHERE("dag_id in (select dag_id from idox_owner_dag where owner_code like CONCAT(#{ownerCode},'%'))");
            }
        }}.toString();
    }

    public static String buildGetDagRunList(@Param("name") String name
                                           ) {
        return "select * from "+name;
    }

    public static String buildGetDagRunCount(@Param("queryEntities") List<QueryEntity> queryEntities,
                                             @Param("ownerCode") String ownerCode,
                                             @Param("creator") String creator) {
        return buildGetDagRun(true, queryEntities, ownerCode, creator);
    }

    private static String buildGetDagRun(boolean getCount,
                                         List<QueryEntity> queryEntities,
                                         String ownerCode,
                                         String creator) {
        return new SQL() {{
            if (getCount)
                SELECT("count(1)");
            else {
                SELECT("id");
                SELECT("dag_id");
                SELECT("state");
                SELECT("execution_date");
                SELECT("start_date");
                SELECT("end_date");
            }
            FROM("dag_run");
            if (queryEntities != null)
                for (int i = 0; i < queryEntities.size(); i++) {
                    QueryEntity query = queryEntities.get(i);
                    switch (query.getField()) {
                        case "dag_id":
                        case "state":
                            WHERE(query.condition(BuilderConstants.QUERY_ENTITIES, i, FieldType.STRING));
                            break;
                        case "id":
                            WHERE(query.condition(BuilderConstants.QUERY_ENTITIES, i, FieldType.NUMBER));
                            break;
                        case "execution_date":
                        case "start_date":
                        case "end_date":
                            WHERE(query.condition(BuilderConstants.QUERY_ENTITIES, i, FieldType.DATETIME));
                            break;
                        default:
                            break;
                    }
                }
            if (!Strings.isNullOrEmpty(ownerCode)) {
                if (!Strings.isNullOrEmpty(creator))
                    WHERE("dag_id in (select dag_id from idox_owner_dag where owner_code = #{ownerCode} and creator = #{creator})");
                else
                    WHERE("dag_id in (select dag_id from idox_owner_dag where owner_code like CONCAT(#{ownerCode},'%'))");
            }
        }}.toString();
    }
}
