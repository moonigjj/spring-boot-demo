package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.product.ProductSpecMapper;
import com.gjy.model.product.ProductSpec;
import com.gjy.web.util.StrUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Service
public class ProductSpecService extends ServiceImpl<ProductSpecMapper, ProductSpec> {

    /**
     * 通过id查询
     * @param productSpecId
     * @return
     */
    @Cacheable(value = "baseCache", unless = "#result == null", key = "'productSpec' + #productSpecId")
    public ProductSpec getProductSpec(Integer productSpecId){
        if (productSpecId == null){
            return null;
        }
        return this.baseMapper.selectById(productSpecId);
    }

    /**
     * 通过商品规格名称查询
     * @param specName 商品规格名称
     * @return
     */
    @Cacheable(value = "baseCache", unless = "#result == null", key = "'productSpec' + #specName")
    public ProductSpec getProductSpecByName(String specName){
        if (StrUtils.isNullOrEmpty(specName)){
            return null;
        }
        return this.baseMapper.selectByName(specName);
    }

    /**
     * 查询未删除的规格
     * @return
     */
    public List<ProductSpec> findAll(){

        return this.baseMapper.selectAllSpec();
    }

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

    /**
     * 新增规格
     * @param spec
     * @return
     */
    public boolean addProductSpec(ProductSpec spec) {

        spec.setDeleted(0);
        int result = this.baseMapper.insertAllColumn(spec);
        if (result < 1){
            return false;
        }
        return true;
    }
}
