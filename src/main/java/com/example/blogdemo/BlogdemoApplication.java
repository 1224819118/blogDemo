package com.example.blogdemo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.blogdemo.Dao")
@ComponentScan({"com.example.blogdemo.Dao","com.example.blogdemo.Controller","com.example.blogdemo.Service"})
public class BlogdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogdemoApplication.class, args);
    }

}
