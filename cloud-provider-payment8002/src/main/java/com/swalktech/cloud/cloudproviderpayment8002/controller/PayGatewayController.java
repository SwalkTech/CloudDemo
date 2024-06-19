package com.swalktech.cloud.cloudproviderpayment8002.controller;

import cn.hutool.core.util.IdUtil;
import com.swalktech.cloud.cloudcommon.entities.PayDTO;
import com.swalktech.cloud.cloudcommon.util.Result;

import com.swalktech.cloud.cloudproviderpayment8002.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@Slf4j
@RestController
@RequestMapping("/pay/gateway")
public class PayGatewayController {

    @Resource
    private PayService payService;

    @GetMapping("/get/{id}")
    @Operation(summary = "查询单个", description = "查询支付流水, 参数是Id")
    public Result<PayDTO> getById(@PathVariable("id") Integer id) {
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(payService.getById(id), payDTO);
        return Result.success(payDTO);
    }

    @GetMapping("/getInfo")
    public Result<String> getInfo() {
        return Result.success("这是网关测试: " + IdUtil.simpleUUID());
    }

    @GetMapping("/filter")
    public Result<String> getFilter(HttpServletRequest request) {
        StringBuilder result = new StringBuilder();
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            String headerValue = request.getHeader(headerName);
            log.info("请求头: {}, 请求值: {}", headerName, headerValue);
            if (headerName.equalsIgnoreCase("X-Request-Wong")) {
                result.append(headerName).append("\t").append(headerValue);
            }
        }
        return Result.success(result + "\t ID: " + IdUtil.simpleUUID());
    }

}