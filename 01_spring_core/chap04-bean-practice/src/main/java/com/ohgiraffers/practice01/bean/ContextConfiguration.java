package com.ohgiraffers.practice01.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {
    public static Long SINGLETON_COUNT=1L;
    public static Long PROTOTYPE_COUNT=1L;

    @Bean
    SingletonBean singletonBean(){
        String message = SINGLETON_COUNT+"번째 메시지";
        SINGLETON_COUNT++;
        return new SingletonBean(message);
    }

    @Bean
    @Scope("prototype")
    PrototypeBean prototypeBean(){
        String message = PROTOTYPE_COUNT+"번째 메시지";
        PROTOTYPE_COUNT++;
        return new PrototypeBean(message);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    InitDestroyBean initDestroyBean(){
        return new InitDestroyBean();
    }
}
