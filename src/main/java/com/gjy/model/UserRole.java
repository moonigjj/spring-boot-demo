package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * Created by gaojiajia on 2017/8/6.
 */
@TableName("sys_user_role")
@Data
public class UserRole extends SuperEntity<UserRole> {

    private Integer userId;

    private Integer roleId;

    private Integer deleted;

}
