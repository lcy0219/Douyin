package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dao")
@SpringBootApplication
public class app {
    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}
