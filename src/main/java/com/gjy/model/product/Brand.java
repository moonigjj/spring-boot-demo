package com.gjy.model.product;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gjy.model.SuperEntity;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Data
@TableName("brand")
public class Brand extends SuperEntity<Brand> {

    private Integer brandNum;

    @NotBlank
    private String name;

    private String remark;

    private Integer deleted;
}
