package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@TableName("sys_user_admin")
@Data
public class UserAdmin extends SuperEntity<UserAdmin> {

    private String userName;

    private String realName;

    private String password;

    private String salt;

    private Integer status;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

}