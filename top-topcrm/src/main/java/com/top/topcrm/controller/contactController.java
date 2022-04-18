package com.top.topcrm.controller;

import com.top.common.core.controller.BaseController;
import com.top.common.core.domain.AjaxResult;
import com.top.common.core.page.TableDataInfo;
import com.top.topcrm.domain.contact;
import com.top.topcrm.service.contactService;
import com.top.topcrm.tool.contactTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import com.top.common.utils.DateUtils;

@RestController
@RequestMapping("/contact")
public class contactController extends BaseController {
    @Autowired
    private contactService contactService;
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    @GetMapping("/list")
    public TableDataInfo getAllContact(){
        startPage();
        List<contact> list = contactService.getAllContact();
        return getDataTable(list);
    }
    @PostMapping("/add")
    public AjaxResult insertContact(@RequestBody @Validated final contactTool contactTool) throws ParseException {
        contact contact = contactTool.coverTo();
        DateUtils dateUtils=new DateUtils();
        Date date = dateUtils.getNowDate();
        Date date1=dateUtils.formatDate(date);
        java.sql.Date sqlDate=dateUtils.transDate(date1);
        contact.setCreate_time(sqlDate);
        contact.setUpdate_time(sqlDate);
        this.contactService.insertContact(contact);
        return AjaxResult.success();
    }
    @DeleteMapping("/delete/{id}")
    public AjaxResult deleteContact(@PathVariable Long id){
         this.contactService.deleteContact(id);
         return AjaxResult.success();
    }
    @PostMapping("/update/{id}")
    public AjaxResult updateContact(@PathVariable Long id,@RequestBody @Validated final contactTool contactTool) throws ParseException {
        contact contact = contactTool.coverTo();
        contact.setId(id);
        DateUtils dateUtils=new DateUtils();
        Date date = dateUtils.getNowDate();
        Date date1=dateUtils.formatDate(date);
        java.sql.Date sqlDate=dateUtils.transDate(date1);
        contact.setUpdate_time(sqlDate);
        this.contactService.updateContact(contact);
        return  AjaxResult.success();
    }
    @GetMapping("/search/{searchKey}")
    public TableDataInfo searchContact(@PathVariable("searchKey") String searchKey){
        startPage();
        List<contact> contacts = this.contactService.searchContact(searchKey);
        return getDataTable(contacts);
    }
    @GetMapping("/getContact/{id}")
    public AjaxResult selectContactById(@PathVariable("id") Long id){
        contact contact = this.contactService.selectContactById(id);
        return AjaxResult.success(contact);
    }
    @GetMapping("/IdAndName")
    public TableDataInfo selectIdAndName(){
        startPage();
        List<contact> contacts=this.contactService.selectIdAndName();
        return getDataTable(contacts);
    }
}
