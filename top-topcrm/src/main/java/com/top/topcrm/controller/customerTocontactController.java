package com.top.topcrm.controller;

import com.top.common.core.controller.BaseController;
import com.top.common.core.page.TableDataInfo;
import com.top.topcrm.domain.customerToContact;
import com.top.topcrm.service.customerTocontactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customerToContact")
public class customerTocontactController extends BaseController {
    @Autowired
    private customerTocontactService customerTocontactService;
    @GetMapping("/list")
    public TableDataInfo searchView(){
        startPage();
        List<customerToContact> customerToContacts = customerTocontactService.searchView();
        return getDataTable(customerToContacts);
    }
}
