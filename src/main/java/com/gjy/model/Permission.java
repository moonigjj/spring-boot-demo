package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@TableName("sys_permission")
@Data
public class Permission extends SuperEntity<Permission> {

    private String name;

    private String remark;


    private static final long serialVersionUID = 1L;
}