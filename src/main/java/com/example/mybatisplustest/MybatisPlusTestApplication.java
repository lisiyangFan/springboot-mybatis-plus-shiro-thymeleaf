package com.example.mybatisplustest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ServletComponentScan(basePackages = "com.example.mybatisplustest.havetry.filter")
@SpringBootApplication()
//@EnableSwagger2
public class MybatisPlusTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisPlusTestApplication.class, args);
  }
}
