package com.example.test.loacl.test.test;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author lizongren
 * @create 2020.05.06 9:35
 */

public class Test implements BeanFactoryAware, ApplicationContextAware, BeanFactoryPostProcessor {
    private static BeanFactory beanFactory;
    private static ApplicationContext applicationContext;

    //@JsonDeserialize(using = CustomTimestampDeserializer.class)
    private String endDate;

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    @JsonSerialize(using = CustomTimestampSerializer.class)
    public String getEndDate() {
        return endDate;
    }

    public static void main(String[] args) {
        Test test=new Test();
    }

    private static void containsString (String ... name){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("s");
        String [] strings1=new String[strings.size()];
        String[] strings2 = strings.toArray(strings1);
        boolean b = Arrays.stream(strings2).allMatch("s"::equals);
        System.out.println(b);
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        Test.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Test.applicationContext = applicationContext;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
        while (beanNamesIterator.hasNext()){
            String next = beanNamesIterator.next();
            System.out.println(next);
        }
    }

}
