package com.gjy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gjy.web.util.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class BuyOrderDTO implements Serializable {
    private static final long serialVersionUID = -2475218010480414716L;

    private Integer id;

    private String productName;

    private BigDecimal price;

    private Integer nums;

    private Integer total;

    @JsonFormat(timezone = "GMT+8", pattern = DateUtils.PATTERN_DAY)
    private Date createTime;

}
