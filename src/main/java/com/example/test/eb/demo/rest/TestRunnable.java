package com.example.test.eb.demo.rest;

import com.example.test.eb.demo.mapper.DagDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author lizongren
 * @create 2020.05.26 15:37
 */

public class TestRunnable implements Runnable {
    private JdbcTemplate jdbcTemplate;
    private DagDao dagDao;
    private int i;
    public TestRunnable(JdbcTemplate jdbcTemplate, DagDao dagDao,int i) {
        this.jdbcTemplate = jdbcTemplate;
        this.dagDao=dagDao;
        this.i=i;
    }

    @Override
    public void run() {
        boolean a;
        /*do {
            try {
                a=false;
                String sql = "insert into method_lock(method_name, method_desc) values('methodName','desc')";
                jdbcTemplate.update(sql);
            }catch (Exception e){
                a=true;
                System.err.println(i+""+e);
            }
        }while (a);*/
        List<Map<String, Object>> data = dagDao.getData("000");
        Object indexs_id = data.get(0).get("indexs");
        Integer integer = Integer.valueOf(String.valueOf(indexs_id));
        String s = String.valueOf(integer + i);
        System.out.println("s-"+s+",i-"+i);
        dagDao.setData("000",s);

        /*String sql = "delete from method_lock where method_name = 'methodName'";
        jdbcTemplate.update(sql);*/
    }
}
