package com.gjy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gjy.web.util.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gaojiajia on 2017/9/20.
 */
@Data
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1656235643784176799L;

    private Integer id;

    private String productName;

    private String brandName;

    @JsonFormat(timezone = "GMT+8", pattern = DateUtils.PATTERN_DAY)
    private Date createTime;

    private String typeName;

    private String specName;

    private String unitName;

}
