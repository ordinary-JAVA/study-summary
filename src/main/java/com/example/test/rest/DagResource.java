package com.example.test.rest;

import com.example.test.bean.Dag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public interface DagResource {

    @GetMapping
    Message<PageList<Dag>> dagInfoList(
            /*@RequestParam("filters") List<String> queryFilters,
            @RequestParam("ownerCode") String ownerCode,
            @RequestParam("creator") String creator,*/
            @RequestParam("currentPage") int currentPage,
            @RequestParam("numberPerPage")  int numberPerPage/*,
            @RequestParam("indexOrderKey") String indexOrderKey,
            @RequestParam("indexOrder")  String indexOrder*/);


}
