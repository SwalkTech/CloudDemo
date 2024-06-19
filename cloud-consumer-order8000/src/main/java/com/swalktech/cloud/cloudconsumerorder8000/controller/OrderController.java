package com.swalktech.cloud.cloudconsumerorder8000.controller;

import com.swalktech.cloud.cloudcommon.entities.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.swalktech.cloud.cloudcommon.util.Result;
import java.util.List;
import java.util.StringJoiner;

@RestController
@RequestMapping("/consumer")
public class OrderController {
    @Resource
    private DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL = "http://cloud-provider-order";

    @Resource
    @LoadBalanced
    private RestTemplate restTemplate;

    @PostMapping("/pay/add")
    public Object addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_URL + "/pay/add", payDTO, Result.class);
    }

    @DeleteMapping("/pay/del/{id}")
    public Object delOrder(@PathVariable("id") Integer id) {
        return restTemplate.exchange(PAYMENT_URL + "/pay/del/" + id, HttpMethod.DELETE, null, Result.class).getBody();
    }

    @PutMapping("/pay/update")
    public Object delOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.exchange(PAYMENT_URL + "/pay/update/", HttpMethod.PUT, new HttpEntity<>(payDTO), Result.class).getBody();
    }

    @GetMapping("/pay/get/{id}")
    public Object getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/" + id, Result.class, id);
    }

    @GetMapping("/pay/getAll")
    public Object getPayListInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/getAll", Result.class);
    }

    @GetMapping("/pay/pay/get/info")
    public Object getInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/pay/get/info", String.class);
    }


    @GetMapping("/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        System.out.println("=================");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            StringJoiner joiner = new StringJoiner("\t");
            joiner.add(instance.getServiceId());
            joiner.add(instance.getHost());
            joiner.add(instance.getPort() + "");
            joiner.add(instance.getUri() + "");
            System.out.println(joiner);
        }
//        return instances.getFirst().getServiceId() + ":" + instances.getFirst().getPort();
        return instances.get(0).getServiceId() + ":" + instances.get(0).getPort();
    }


}
