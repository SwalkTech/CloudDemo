package com.swalktech.cloud.cloudproviderpayment8003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swalktech.cloud.cloudproviderpayment8003.mapper")
public class CloudProviderPayment8003Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8003Application.class, args);
    }

}
