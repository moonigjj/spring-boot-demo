package com.gjy.model.product;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gjy.model.SuperEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Data
@TableName("product")
public class Product extends SuperEntity<Product> {

    @TableField(value = "name")
    private String name;

    @TableField(value = "product_type_id")
    private Integer productTypeId;

    @TableField(value = "brand_id")
    private Integer brandId;

    @TableField(value = "product_spec_id")
    private Integer productSpecId;

    @TableField(value = "product_unit_id")
    private Integer productUnitId;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "deleted")
    private Integer deleted;
}
