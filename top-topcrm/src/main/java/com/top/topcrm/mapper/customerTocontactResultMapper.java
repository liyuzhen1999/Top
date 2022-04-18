package com.top.topcrm.mapper;

import com.top.topcrm.domain.customerToContact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface customerTocontactResultMapper {
    List<customerToContact> searchView();
}
