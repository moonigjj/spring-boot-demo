package com.gjy.model.order;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gjy.model.SuperEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("sale_order")
public class SaleOrder extends SuperEntity<SaleOrder> {

    @TableField("order_id")
    private String orderId;

    @TableField("product_id")
    private Integer productId;

    @TableField("price")
    private BigDecimal price;

    @TableField("nums")
    private Integer nums;

    @TableField("total")
    private BigDecimal total;

    @TableField("deleted")
    private Integer deleted;
}
