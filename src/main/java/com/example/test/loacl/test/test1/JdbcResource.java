package com.example.test.loacl.test.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lizongren
 * @create 2020.06.02 10:11
 * <p>
 * <p>
 * 测试jdbcTemplate的批量插入与普通插入的效率(单表) 有一个普通索引 无主键索引
 * 批量插入  1000-200ms     10000-355ms     1000000-112045ms
 * 普通插入  1000-13000ms   10000-135803ms
 *
 * 测试jdbcTemplate的批量插入与普通插入的效率(单表)有主键索引
 * 批量插入  1000-68ms     10000-355ms     1000000-45816ms   一亿数据:2800s
 * 普通插入  1000-13000ms   10000-135803ms
 */

@RestController
@RequestMapping("/jdbc")
public class JdbcResource {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/2")
    public Long add() throws SQLException {
        long l = System.currentTimeMillis();
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int a = 0; a < 20000; a++) {
            Map<String, Object> map = new HashMap<>();
            map.put("imei", String.valueOf(a));
            map.put("listId", String.valueOf(a));
            map.put("indexs", String.valueOf(a));
            map.put("statTime", String.valueOf(a));
            map.put("endTime", String.valueOf(a));
            mapList.add(map);
        }
        for (int i = 0; i < 1; i++) {
            System.out.println("start"+i);
            listSelFunc2(mapList);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l);
        return l2 - l;
    }


    @GetMapping("/https")
    public String testHttps() throws SQLException {
        System.out.println("https");
        return "test success";
    }
    @GetMapping("/https1")
    public String testHttps1() throws SQLException {
        System.out.println("https1");
        return "test success1";
    }
    public void listSelFunc2(List<Map<String, Object>> mapList)
            throws SQLException {
        //将文件数据导入mysql表
        String insertsql = "INSERT INTO busi_ods_imp_information (list_id, imei,indexs,stat_time,end_time)"
                + "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(insertsql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> map = mapList.get(i);
                ps.setString(1, map.get("listId").toString());
                ps.setString(2, map.get("imei").toString());
                ps.setString(3, map.get("indexs").toString());
                ps.setString(4, map.get("statTime").toString());
                ps.setString(5, map.get("endTime").toString());
            }

            @Override
            public int getBatchSize() {
                return mapList.size();
            }
        });
    }

    @GetMapping("/3")
    public Long addSingle() {
        long l = System.currentTimeMillis();
        String insertsql = "INSERT INTO busi_ods_imp_information (list_id, imei,indexs,stat_time,end_time)"
                + "VALUES (?, ?, ?, ?, ?)";
        for (int a = 0; a < 1000; a++) {
            jdbcTemplate.update(insertsql, String.valueOf(a), String.valueOf(a), String.valueOf(a), String.valueOf(a), String.valueOf(a));
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l);
        return l2 - l;

    }
    @GetMapping("/4")
   public String test(@RequestParam("num") String num) throws InterruptedException {
        Integer integer = Integer.valueOf(num+"0000");
        long l = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int w=0;w<200;w++){
            System.out.println(w);
        //将文件数据导入mysql表
        for (int a=0;a<10;a++){
            Integer start=3000000+a*integer;
            Integer end=3000000+(a+1)*integer;
            executorService.execute(new JdbcRunnable(jdbcTemplate,start,end));
        }
        Thread.sleep(15000L);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l);
        return String.valueOf(l2 - l);
   }


}
