package com.top.topcrm.mapper;

import com.top.topcrm.domain.contact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface contactMapper {
    List<contact> getAllContact();
    Integer insertContact(contact contact);
    Integer deleteContact(Long id);
    Integer updateContact(contact contact);
    List<contact> searchContact(String searchKey);
    contact selectContactById(Long id);
    List<contact> selectIdAndName();
}
