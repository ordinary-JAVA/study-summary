package com.example.test.study.summary.util;

import org.springframework.util.StopWatch;

import java.util.*;
import java.util.stream.Collectors;

public class Induce {
    static final Integer SIZE=100000;
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < SIZE; ) {
            list.add(i++);
        }

        Collections.shuffle(list);
        //list.stream().forEach(s->System.out.println(s));

        stopWatch.start("sorted");
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());;
    }
}
