package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("sys_permission")
public class Permission extends SuperEntity<Permission> {

    private String name;

    private String desc;


    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

}