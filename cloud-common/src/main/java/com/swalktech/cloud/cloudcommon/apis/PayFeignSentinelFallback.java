package com.swalktech.cloud.cloudcommon.apis;


import com.swalktech.cloud.cloudcommon.entities.PayDTO;
import com.swalktech.cloud.cloudcommon.util.Result;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelFallback implements PayFeignSentinelApi {
    @Override
    public Result<PayDTO> getPayByOrderNo(String orderNo) {
        return Result.fail("服务不可达");
    }
}
