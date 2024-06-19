package com.swalktech.cloud.cloudproviderpayment8002.service;





import com.swalktech.cloud.cloudproviderpayment8002.pojo.Pay;

import java.util.List;

public interface PayService {

    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
