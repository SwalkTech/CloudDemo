package com.swalktech.cloud.cloudproviderpayment8001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.swalktech.cloud.cloudproviderpayment8001.mapper")
@EnableDiscoveryClient
public class CloudProviderPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8001Application.class, args);
    }

}
