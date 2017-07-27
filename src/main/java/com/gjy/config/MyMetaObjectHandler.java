package com.gjy.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * ClassName:MyMetaObjectHandler
 *
 * @author ty
 * @description 公共字段填充
 * @create 2017/7/14 11:15
 **/
public class MyMetaObjectHandler extends MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {

        setFieldValByName("createTime", new Date(), metaObject);
        setFieldValByName("updateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        setFieldValByName("updateTime", new Date(), metaObject);
    }
}
