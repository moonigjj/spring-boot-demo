package com.gjy.mapper.product;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.product.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
public interface BrandMapper extends SuperMapper<Brand> {

    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<Brand> selectListPage(Pagination page, Map<String, Object> params);

    /**
     * 通过商品名称查询
     * @param brandName 商品名称
     * @return
     */
    Brand selectByName(@Param("brandName") String brandName);

    /**
     * 查询全部未删除
     * @return
     */
    List<Brand> selectAllBrand();
}
