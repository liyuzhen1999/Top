package com.top.topcrm.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class contact {
    private long id;
    private String name;
    private String phone;
    private String isLeft;
    private String address;
    private String creater;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
    private String updater;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String isLeft() {
        return isLeft;
    }

    public void setLeft(String left) {
        isLeft = left;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsLeft() {
        return isLeft;
    }

    public void setIsLeft(String isLeft) {
        this.isLeft = isLeft;
    }
}
