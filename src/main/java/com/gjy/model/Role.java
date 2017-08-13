package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@TableName("sys_role")
@Data
public class Role extends SuperEntity<Role> {

    private String name;

    private String remark;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}