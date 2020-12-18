package com.example.test.loacl.test.test;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Induce2 {
    static final Integer SIZE=100000;
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < SIZE; ) {
            list.add(i++);
        }

        Collections.shuffle(list);
        //list.stream().forEach(s->System.out.println(s));
        stopWatch.start("分而治之");
        int f=SIZE/2;
        List<Integer>left=new ArrayList<>(f);
        List<Integer>right=new ArrayList<>(f);

        for (int i=0;i<list.size();i++){
            if (list.get(i)<f){
                left.add(list.get(i));
            }else{
                right.add(list.get(i));
            }
        }
        List<Integer> leftAfter = left.stream().sorted().collect(Collectors.toList());
        List<Integer> rightAfter = right.stream().sorted().collect(Collectors.toList());
        list.clear();
        list.addAll(leftAfter);
        list.addAll(rightAfter);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());;
    }
}
