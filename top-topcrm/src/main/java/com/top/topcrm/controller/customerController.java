package com.top.topcrm.controller;

import com.top.common.core.controller.BaseController;
import com.top.common.core.domain.AjaxResult;
import com.top.common.core.page.TableDataInfo;
import com.top.common.utils.DateUtils;
import com.top.topcrm.domain.customer;
import com.top.topcrm.service.customerService;


import com.top.topcrm.tool.customerTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class customerController extends BaseController {

    @Autowired
    public customerService customerService;

    @GetMapping("/list")
    public TableDataInfo getAllCustomer(){
        startPage();
        List<customer> list=customerService.getAllCustomer();
//        System.out.println("控制器执行");
        return getDataTable(list);
    }

    @PostMapping("/update/{id}")
    public AjaxResult updateCustomer(@PathVariable("id") Long id, @RequestBody @Validated final customerTool customerTool) throws ParseException {
        customer customer=customerTool.coverTo();
        customer.setId(id);
        DateUtils dateUtils=new DateUtils();
        Date date = dateUtils.getNowDate();
        Date date1=dateUtils.formatDate(date);
        java.sql.Date sqlDate=dateUtils.transDate(date1);
        customer.setUpdate_time(sqlDate);
        this.customerService.updateCustomer(customer);
        return AjaxResult.success();
    }
    @DeleteMapping("/delete/{id}")
    public AjaxResult deleteCustomer(@PathVariable("id") Long id){
        this.customerService.deleteCustomer(id);
        return AjaxResult.success();
    }
    @PostMapping("/add")
    public AjaxResult insertCustomer(@RequestBody @Validated final customerTool customerTool) throws ParseException {
        customer customer=customerTool.coverTo();
        DateUtils dateUtils=new DateUtils();
        Date date = dateUtils.getNowDate();
        Date date1=dateUtils.formatDate(date);
        java.sql.Date sqlDate=dateUtils.transDate(date1);
        customer.setCreate_time(sqlDate);
        customer.setUpdate_time(sqlDate);
        this.customerService.insertCutomer(customer);
        return AjaxResult.success();
    }
    @GetMapping("/search/{searchParam}")
    public TableDataInfo searchCustomer(@PathVariable("searchParam") String searchParam){
        startPage();
        List<customer> list=this.customerService.searchCustomer(searchParam);
        return getDataTable(list);
    }
    @GetMapping("/select/{id}")
    public TableDataInfo selectCustomerById(@PathVariable("id") Long id){
        startPage();
        List<customer> list = this.customerService.selectCustomerById(id);
        return  getDataTable(list);
    }

}
