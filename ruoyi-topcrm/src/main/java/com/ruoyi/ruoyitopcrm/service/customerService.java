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
    public Integer updateCustomer(customer customer){
        return this.customerMapper.updateCustomer(customer);
    }
    public Integer deleteCustomer(Long id){
        return this.customerMapper.deleteCustomer(id);
    }
    public Integer insertCutomer(customer customer){
        return this.customerMapper.insertCustomer(customer);
    }
    public List<customer> searchCustomer(String searchParam){
        return this.customerMapper.searchCustomer(searchParam);
    }
    public List<customer> selectCustomerById(Long id){
        return this.customerMapper.selectCustomerById(id);
    }
}
