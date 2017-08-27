package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@TableName("sys_user_admin")
@Data
public class UserAdmin extends SuperEntity<UserAdmin> {

    @NotEmpty
    @Max(value = 16, message = "长度不能大于16")
    @Min(value = 2, message = "长度不能小于2")
    private String userName;

    @NotEmpty
    @Max(value = 16, message = "长度不能大于16")
    @Min(value = 2, message = "长度不能小于2")
    private String realName;

    @NotEmpty
    @Max(value = 16, message = "长度不能大于16")
    @Min(value = 2, message = "长度不能小于2")
    private String password;

    private String salt;

    private Integer status;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

}