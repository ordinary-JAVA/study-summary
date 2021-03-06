package com.example.test.eb.demo.controller;

import com.example.test.eb.demo.bean.Dag;
import com.example.test.eb.demo.mapper.DagDao;
import com.example.test.eb.demo.bean.QueryEntity;
import com.example.test.eb.demo.task.DataTask;
import com.example.test.eb.demo.util.Message;
import com.example.test.eb.demo.util.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/test")
public class DagResourceImpl implements DagResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(DagResourceImpl.class);
    @Autowired
    private DagDao dagDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Message<PageList<Dag>> dagInfoList(/*List<String> queryFilters, String ownerCode, String owner,*/
                                              int currentPage, int numberPerPage/*, String indexOrderKey, String indexOrder*/) {
        List<QueryEntity> queryEntities = null;
       /* if (queryFilters != null && queryFilters.size() > 0) {
            queryEntities = queryFilters
                    .stream()
                    .map(entity -> JSON.parseObject(entity, QueryEntity.class))
                    .collect(Collectors.toList());
        }*/
        /*List<Dag> dags = dagDao.getDagList(queryEntities, ownerCode, owner, currentPage, numberPerPage, indexOrderKey, indexOrder);
        int dagCount = dagDao.getDagCount(queryEntities, ownerCode, owner);*/
        List<Dag> dags = dagDao.getDagList(queryEntities, null, null, currentPage, numberPerPage, null, null);
        int dagCount = dagDao.getDagCount(queryEntities, null, null);
        return Message.success(new PageList<>(dags, currentPage, dagCount));
    }

    @Override
    public Message<String> test() {
        String sql="select * from sc";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(l->l.forEach((k,v)->{
            System.out.println(k+"-"+v);
        }));
        return Message.success("test");
    }

    @Override
    public Message<List<Map<String,Object>>> dagInfoList2(/*List<String> queryFilters, String ownerCode, String owner,*/
            String name/*, String indexOrderKey, String indexOrder*/) {
        List<QueryEntity> queryEntities = null;
       /* if (queryFilters != null && queryFilters.size() > 0) {
            queryEntities = queryFilters
                    .stream()
                    .map(entity -> JSON.parseObject(entity, QueryEntity.class))
                    .collect(Collectors.toList());
        }*/
        /*List<Dag> dags = dagDao.getDagList(queryEntities, ownerCode, owner, currentPage, numberPerPage, indexOrderKey, indexOrder);
        int dagCount = dagDao.getDagCount(queryEntities, ownerCode, owner);*/
        List<Map<String,Object>> dags = dagDao.getRunList(name);

        return Message.success(dags);
    }

    @Override
    @Transactional
    public Message<List<Map<String, Object>>> updateData(String name, String id) {
        try {
            dagDao.updateData(name,id);
            List<Map<String, Object>> maps = dagDao.queryData(name);
            System.out.println(1/0);
            maps.forEach(map -> {
                for (Map.Entry<String,Object> s : map.entrySet()){
                    System.out.println("key -"+s.getKey()+",value-"+s.getValue());
                };
            });
            return Message.success(maps);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return Message.fail("no");
        }

    }

    @Override
    public Message<List<Map<String, Object>>> addData() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            int a=0;
           for (int i=0;i<100;i++){
                a+=i;
                executorService.execute(new DataTask(jdbcTemplate,dagDao,i));
            }
            return Message.success("success"+a);
        }catch (Exception e){
            return Message.fail("fail");
        }

    }

}
