package com.ruoyi.ruoyitopcrm.service;

import com.ruoyi.ruoyitopcrm.domain.customer;
import com.ruoyi.ruoyitopcrm.mapper.customerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerService {
    @Autowired
    private customerMapper customerMapper;

    public List<customer> getAllCustomer(){
//        System.out.println("服务层执行");
        List<customer> allCustomer = customerMapper.getAllCustomer();
        return allCustomer;
    }
}
