package com.example.test.testBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public User user(){
        User user = new User();
        user.setName("lizongren");
        user.setAge("24");
        return user;
    }
}
