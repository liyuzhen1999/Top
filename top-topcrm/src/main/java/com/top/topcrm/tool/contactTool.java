package com.top.topcrm.tool;

import com.top.topcrm.domain.contact;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Date;

public class contactTool {
    @NotNull(message="主键不能为空")
    private long id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @NotBlank(message = "是否离职不能为空")
    private String isLeft;
    @NotBlank(message = "地址不能为空")
    private String address;
    private String creater;
    private String updater;

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


    public String getIsLeft() {
        return isLeft;
    }

    public void setIsLeft(String isLeft) {
        this.isLeft = isLeft;
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


    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public contact coverTo(){
        contact contact=new contact();
        contact.setName(this.name);
        contact.setPhone(this.phone);
        contact.setLeft(this.isLeft);
        contact.setAddress(this.address);
        contact.setCreater(this.creater);
        contact.setUpdater(this.updater);
        return contact;
    }
}
