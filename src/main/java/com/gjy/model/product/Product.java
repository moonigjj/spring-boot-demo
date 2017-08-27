package com.gjy.model.product;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gjy.model.SuperEntity;
import lombok.Data;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Data
@TableName("product")
public class Product extends SuperEntity<Product> {

    private Integer productTypeId;

    private String name;

    private Integer productSpecId;

    private Integer productUnitId;

    private Integer price;

    private String remark;
}
