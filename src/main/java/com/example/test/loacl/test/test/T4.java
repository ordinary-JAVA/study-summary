package com.example.test.loacl.test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizongren
 * @create 2020.05.13 12:35
 */

public class T4 {
    public static void main(String[] args) {
        T4Interface t4Interface = (s) -> String.valueOf(s.length());
        System.out.println(t4Interface.outPut("wangliang"));
        List<String> list=new ArrayList<>();
        list.add("test");
        list.stream().forEach(System.out::println);

    }


}
