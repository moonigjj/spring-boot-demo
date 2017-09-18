package com.gjy.mapper.product;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.product.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
public interface ProductTypeMapper extends SuperMapper<ProductType> {

    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<ProductType> selectListPage(Pagination page, Map<String, Object> params);

    /**
     * 通过商品分类名称查询
     * @param typeName 商品分类名称
     * @return
     */
    ProductType selectByName(@Param("typeName") String typeName);

    /**
     * 查询全部未删除
     * @return
     */
    List<ProductType> selectAllType();
}
