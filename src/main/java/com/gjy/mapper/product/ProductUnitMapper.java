package com.gjy.mapper.product;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.product.ProductUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
public interface ProductUnitMapper extends SuperMapper<ProductUnit> {

    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<ProductUnit> selectListPage(Pagination page, Map<String, Object> params);

    /**
     * 通过计量单位名称查询
     * @param unitName 计量单位名称
     * @return
     */
    ProductUnit selectByName(@Param("unitName") String unitName);
}
