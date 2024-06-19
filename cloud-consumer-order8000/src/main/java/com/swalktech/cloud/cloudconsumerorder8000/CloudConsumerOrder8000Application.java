package com.swalktech.cloud.cloudconsumerorder8000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerOrder8000Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder8000Application.class, args);
    }

}
