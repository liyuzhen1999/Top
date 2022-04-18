package com.top.topcrm.service;


import com.top.topcrm.domain.customer;
import com.top.topcrm.mapper.customerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerService {
    @Autowired
    private customerMapper customerMapper;

    public List<customer> getAllCustomer(){
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
