package com.dmazui.apidistocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiDistocksApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiDistocksApplication.class, args);
    }
}
