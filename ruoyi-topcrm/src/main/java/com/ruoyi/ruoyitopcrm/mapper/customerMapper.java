package com.ruoyi.ruoyitopcrm.mapper;

import com.ruoyi.ruoyitopcrm.domain.customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface customerMapper {

    List<customer> getAllCustomer();
    Integer updateCustomer(customer customer);
    Integer deleteCustomer(Long id);
    Integer insertCustomer(customer customer);
    List<customer> searchCustomer(String searchParam);
    List<customer> selectCustomerById(Long id);
}
