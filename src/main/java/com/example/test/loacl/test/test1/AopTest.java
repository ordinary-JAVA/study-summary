package com.example.test.loacl.test.test1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author lizongren
 * @create 2020.06.05 9:45
 */

@Component
@Aspect
public class AopTest {

    @After("execution(* com.example.test.loacl.test.test1.JdbcResource.*(..)))")
    public void before(){
        System.out.println("带租客看房");
        System.out.println("谈价格");
    }


}
