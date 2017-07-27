package com.gjy.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.FieldStrategy;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:SuperEntity
 *
 * @author ty
 * @description 实体父类
 * @create 2017/7/11 14:51
 **/

public class SuperEntity<T extends Model> extends Model<T> {

    @TableId("id")
    private Integer id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @TableField(value = "create_time", strategy = FieldStrategy.NOT_EMPTY, fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",strategy = FieldStrategy.NOT_EMPTY, fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
