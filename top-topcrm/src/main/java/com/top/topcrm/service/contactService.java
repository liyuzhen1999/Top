package com.top.topcrm.service;

import com.top.common.core.domain.AjaxResult;
import com.top.topcrm.domain.contact;
import com.top.topcrm.mapper.contactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class contactService {
    @Autowired
    private contactMapper contactMapper;

    public List<contact> getAllContact(){
        return contactMapper.getAllContact();
    }
    public Integer insertContact(contact contact){
        return contactMapper.insertContact(contact);
    }
    public Integer deleteContact(Long id){return contactMapper.deleteContact(id);}
    public Integer updateContact(contact contact){return contactMapper.updateContact(contact);}
    public List<contact> searchContact(String searchKey){return contactMapper.searchContact(searchKey);}
    public contact selectContactById(Long id){return contactMapper.selectContactById(id);}
    public List<contact> selectIdAndName(){return contactMapper.selectIdAndName();}
}
