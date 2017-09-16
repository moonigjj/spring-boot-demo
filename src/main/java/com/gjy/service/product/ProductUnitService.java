package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.product.ProductUnitMapper;
import com.gjy.model.product.ProductUnit;
import com.gjy.web.util.StrUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Service
public class ProductUnitService extends ServiceImpl<ProductUnitMapper, ProductUnit> {


    /**
     * 通过id查询
     * @param productUnitId
     * @return
     */
    @Cacheable(value = "baseCache", key = "'productType' + #productUnitId")
    public ProductUnit getProductUnit(Integer productUnitId){
        if (productUnitId == null){
            return null;
        }
        return this.baseMapper.selectById(productUnitId);
    }

    /**
     * 通过计量单位名称查询
     * @param unitName 计量单位名称
     * @return
     */
    @Cacheable(value = "baseCache", unless = "#result == null", key = "'productUnit' + #unitName")
    public ProductUnit getProductUnitByName(String unitName){
        if (StrUtils.isNullOrEmpty(unitName)){
            return null;
        }
        return this.baseMapper.selectByName(unitName);
    }

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
