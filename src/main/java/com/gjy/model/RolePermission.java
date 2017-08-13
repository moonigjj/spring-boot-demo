package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * Created by gaojiajia on 2017/8/9.
 */
@TableName("sys_role_permission")
@Data
public class RolePermission extends SuperEntity<RolePermission> {

    private Integer roleId;

    private String permission;

    private Integer deleted;
}
