package com.ruoyi.ruoyitopcrm.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.ruoyitopcrm.domain.customer;
import com.ruoyi.ruoyitopcrm.service.customerService;
import com.ruoyi.ruoyitopcrm.tool.customerTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public AjaxResult updateCustomer(@PathVariable("id") Long id, @RequestBody @Validated final customerTool customerTool){
        customer customer=customerTool.coverTo();
        customer.setId(id);
        this.customerService.updateCustomer(customer);
        return AjaxResult.success();
    }
    @DeleteMapping("/delete/{id}")
    public AjaxResult deleteCustomer(@PathVariable("id") Long id){
        this.customerService.deleteCustomer(id);
        return AjaxResult.success();
    }
    @PostMapping("/add")
    public AjaxResult insertCustomer(@RequestBody @Validated final customerTool customerTool){
        customer customer=customerTool.coverTo();
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
