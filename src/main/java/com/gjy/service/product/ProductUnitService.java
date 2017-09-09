package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.product.ProductUnitMapper;
import com.gjy.model.Role;
import com.gjy.model.product.ProductUnit;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Service
public class ProductUnitService extends ServiceImpl<ProductUnitMapper, ProductUnit> {

    /**
     * 分页列表查询
     * @param page 分页对象
     * @param params 条件参数
     * @return
     */
    public Page<ProductUnit> findListPage(Page<ProductUnit> page, Map<String, Object> params){

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }

    public boolean addProductUnit(ProductUnit unit) {

        unit.setDeleted(0);
        int result = this.baseMapper.insertAllColumn(unit);
        if (result < 1){
            return false;
        }
        return true;
    }
}
