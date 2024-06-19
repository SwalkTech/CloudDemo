package com.swalktech.cloud.cloudproviderpayment8002.service.serviceImpl;



import com.swalktech.cloud.cloudproviderpayment8002.mapper.PayMapper;
import com.swalktech.cloud.cloudproviderpayment8002.pojo.Pay;
import com.swalktech.cloud.cloudproviderpayment8002.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;


    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
