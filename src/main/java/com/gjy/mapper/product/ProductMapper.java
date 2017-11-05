package com.gjy.mapper.product;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.dto.ProductDTO;
import com.gjy.model.product.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
public interface ProductMapper extends SuperMapper<Product> {

    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<ProductDTO> selectListPage(Pagination page, Map<String, Object> params);
}
