package com.i5.springmybatiscrud.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.i5.springmybatiscrud")
@MapperScan(basePackages = "com.i5.springmybatiscrud")
public class SpringMybatisCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisCrudApplication.class, args);
    }

}
