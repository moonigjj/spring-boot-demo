package com.gjy.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_resource")
@Data
public class Resource extends SuperEntity<Resource> {

    private String name;

    private String remark;

    private String url;

    private String icon;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

}