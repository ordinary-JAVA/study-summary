package com.example.test.loacl.test.testBean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author lizongren
 * @create 2020.05.29 20:16
 */

@Component
public class Student implements BeanNameAware {


    private String name;

    public Student() {
        super();
        System.out.println("super");
    }

    public void setName(String name) {
        System.out.println("set方法");
        this.name = name;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("调用setBeanName");
    }
}
