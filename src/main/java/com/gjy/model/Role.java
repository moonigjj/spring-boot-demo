package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("sys_role")
public class Role extends SuperEntity<Role> {

    private String name;

    private String desc;

    private Integer deleted;

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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}