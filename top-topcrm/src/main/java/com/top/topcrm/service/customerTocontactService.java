package com.top.topcrm.service;

import com.top.topcrm.domain.customerToContact;
import com.top.topcrm.mapper.customerTocontactResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerTocontactService {
    @Autowired
    private customerTocontactResultMapper customerTocontactResultMapper;
    public List<customerToContact> searchView(){return this.customerTocontactResultMapper.searchView();}
}
