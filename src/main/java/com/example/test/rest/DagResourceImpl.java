package com.example.test.rest;

import com.alibaba.fastjson.JSON;
import com.example.test.bean.Dag;
import com.example.test.mapper.DagDao;
import com.example.test.mapper.QueryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class DagResourceImpl implements DagResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(DagResourceImpl.class);

    @Autowired
    private DagDao dagDao;

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


}
