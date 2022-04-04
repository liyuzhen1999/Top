package com.ruoyi.ruoyitopcrm.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.ruoyitopcrm.domain.customer;
import com.ruoyi.ruoyitopcrm.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
