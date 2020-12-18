package com.example.test.loacl.test.test1;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lizongren
 * @create 2020.06.02 11:23
 */

public class JdbcRunnable implements Runnable {
    private JdbcTemplate jdbcTemplate;
    private Integer start;
    private Integer end;


    public JdbcRunnable(JdbcTemplate jdbcTemplate, Integer start,Integer end) {
        this.jdbcTemplate = jdbcTemplate;
        this.end = end;
        this.start = start;

    }

    @Override
    public void run() {
        String sql="select * from busi_ods_imp_information where id > ? and id<= ?";
        // 102826783
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql,start,end);

        String insertsql = "INSERT INTO busi_ods_imp_information1 (list_id, imei,indexs,stat_time,end_time)"
                + "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(insertsql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> map = maps.get(i);
                ps.setString(1, map.get("list_id").toString());
                ps.setString(2, map.get("imei").toString());
                ps.setString(3, map.get("indexs").toString());
                ps.setString(4, map.get("stat_time").toString());
                ps.setString(5, map.get("end_time").toString());
            }

            @Override
            public int getBatchSize() {
                return maps.size();
            }
        });
        System.out.println(start+"-----当前时间"+new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
    }
}
