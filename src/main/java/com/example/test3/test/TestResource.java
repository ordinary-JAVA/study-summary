package com.example.test3.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizongren
 * @create 2020.04.15 10:26
 */

@RestController
@RequestMapping("/test")
public class TestResource {


    @PostMapping("/post")
    public String s1(@RequestParam("name") String name) {
        System.out.println("test");
        return name;
    }
}
