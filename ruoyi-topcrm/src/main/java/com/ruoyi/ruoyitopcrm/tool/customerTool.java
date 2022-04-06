package com.ruoyi.ruoyitopcrm.tool;

import com.ruoyi.ruoyitopcrm.domain.customer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class customerTool {
    @NotNull(message = "主键不能为空")
    private long id;//主键
    @NotBlank(message = "顾客名称不能为空")
    private String customer_name;//顾客名称
    @NotBlank(message = "顾客手机号不能为空")
    private String customer_phone;//顾客手机号
    @NotBlank(message = "邮箱不能为空")
    private String customer_email;//邮箱
    @NotBlank(message = "顾客地址不能为空")
    private String customer_address;//顾客地址
    @NotBlank(message = "顾客传真不能为空")
    private String customer_fax;//顾客传真
    @NotBlank(message = "顾客代表人不能为空")
    private String customer_representor;//顾客代表人
    @NotBlank(message = "代表人职务不能为空")
    private String customer_post;//代表人职务
    @NotNull(message = "联系人序号不能为空")
    private long contact_id;//联系人序号
    @NotBlank(message = "联系人姓名不能为空")
    private String contact_name;//联系人姓名

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_fax() {
        return customer_fax;
    }

    public void setCustomer_fax(String customer_fax) {
        this.customer_fax = customer_fax;
    }

    public String getCustomer_representor() {
        return customer_representor;
    }

    public void setCustomer_representor(String customer_representor) {
        this.customer_representor = customer_representor;
    }

    public String getCustomer_post() {
        return customer_post;
    }

    public void setCustomer_post(String customer_post) {
        this.customer_post = customer_post;
    }

    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public customer coverTo(){
        customer customer=new customer();
        customer.setCustomer_name(this.customer_name);
        customer.setCustomer_fax(this.customer_fax);
        customer.setCustomer_phone(this.customer_phone);
        customer.setCustomer_address(this.customer_address);
        customer.setCustomer_post(this.customer_post);
        customer.setContact_id(this.contact_id);
        customer.setContact_name(this.contact_name);
        customer.setCustomer_email(this.customer_email);
        return customer;
    }
}
