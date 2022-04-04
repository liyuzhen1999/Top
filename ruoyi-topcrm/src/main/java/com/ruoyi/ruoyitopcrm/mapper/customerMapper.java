package com.ruoyi.ruoyitopcrm.mapper;

import com.ruoyi.ruoyitopcrm.domain.customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface customerMapper {

    List<customer> getAllCustomer();
}
