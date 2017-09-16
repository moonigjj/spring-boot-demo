package com.gjy.mapper.product;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.product.ProductSpec;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
public interface ProductSpecMapper extends SuperMapper<ProductSpec> {

    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<ProductSpec> selectListPage(Pagination page, Map<String, Object> params);

    /**
     * 通过商品规格名称查询
     * @param specName 商品规格名称
     * @return
     */
    ProductSpec selectByName(@Param("specName") String specName);
}
