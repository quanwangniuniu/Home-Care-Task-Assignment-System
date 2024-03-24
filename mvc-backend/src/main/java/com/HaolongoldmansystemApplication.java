package com;

import com.example.haolongoldmansystem.Controller.OldmanController;
import com.example.haolongoldmansystem.Service.OldmanService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.haolongoldmansystem.Dao")
public class HaolongoldmansystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaolongoldmansystemApplication.class, args);
    }
}
