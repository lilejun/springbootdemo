package com.lilejun.mybatisplustest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lilejun.mybatisplustest.mptest.mapper")
@SpringBootApplication
public class MybatisPlusTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusTestApplication.class, args);
    }

}