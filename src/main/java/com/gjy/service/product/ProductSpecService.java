package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.product.ProductSpecMapper;
import com.gjy.model.product.ProductSpec;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Service
public class ProductSpecService extends ServiceImpl<ProductSpecMapper, ProductSpec> {

    /**
     * 分页列表查询
     * @param page 分页对象
     * @param params 条件参数
     * @return
     */
    public Page<ProductSpec> findListPage(Page<ProductSpec> page, Map<String, Object> params){

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }

    public boolean addProductSpec(ProductSpec spec) {

        spec.setDeleted(0);
        int result = this.baseMapper.insertAllColumn(spec);
        if (result < 1){
            return false;
        }
        return true;
    }
}
