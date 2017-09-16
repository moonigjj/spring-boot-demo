package com.gjy.model.product;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gjy.model.SuperEntity;
import com.gjy.web.valid.ValidAdd;
import com.gjy.web.valid.ValidEdit;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Data
@TableName("product_unit")
public class ProductUnit extends SuperEntity<ProductUnit> {

    @NotBlank
    private String name;

    @NotBlank(groups = {ValidAdd.class, ValidEdit.class})
    private String remark;

    private Integer deleted;

}
