package com.top.topcrm.domain;

import java.sql.Date;

public class customer {
    private long id;//主键
    private String customer_name;//客户名称
    private String customer_phone;//客户手机号
    private String customer_email;//客户邮箱
    private String customer_address;//客户地址
    private String customer_fax;//客户传真
    private String customer_representor;//客户代表人
    private String customer_post;//客户代表人职务
    private long contact_id;//联系人序号
    private String contact_name;//联系人姓名
    private String creater;//创建者姓名
    private Date create_time;//创建时间
    private String updater;//修改者
    private Date update_time;//修改时间

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

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
