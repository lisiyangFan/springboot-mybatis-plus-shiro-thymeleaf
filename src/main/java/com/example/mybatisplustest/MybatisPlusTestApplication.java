package com.example.mybatisplustest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

//@ServletComponentScan(basePackages = "com.example.mybatisplustest.havetry.filter")
@MapperScan("com.example.mybatisplustest.havetry.mapper")
@SpringBootApplication
public class MybatisPlusTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusTestApplication.class, args);
    }
}
