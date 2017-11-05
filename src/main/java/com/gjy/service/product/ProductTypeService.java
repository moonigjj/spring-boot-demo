package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.product.ProductTypeMapper;
import com.gjy.model.product.ProductType;
import com.gjy.web.util.StrUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Service
public class ProductTypeService extends ServiceImpl<ProductTypeMapper, ProductType> {


    /**
     * 通过id查询
     * @param productTypeId
     * @return
     */
    @Cacheable(value = "baseCache", key = "'productType' + #productTypeId")
    public ProductType getProductType(Integer productTypeId){
        if (productTypeId == null){
            return null;
        }
        return this.baseMapper.selectById(productTypeId);
    }

    /**
     * 通过商品分类名称查询
     * @param typeName 商品分类名称
     * @return
     */
    @Cacheable(value = "baseCache", unless = "#result == null", key = "'productType' + #typeName")
    public ProductType getProductTypeByName(String typeName){
        if (StrUtils.isNullOrEmpty(typeName)){
            return null;
        }
        return this.baseMapper.selectByName(typeName);
    }

    /**
     * 查询未删除的商品类型
     * @return
     */
    public List<ProductType> findAll(){

        return this.baseMapper.selectAllType();
    }

    /**
     * 分页列表查询
     * @param page 分页对象
     * @param params 条件参数
     * @return
     */
    public Page<ProductType> findListPage(Page<ProductType> page, Map<String, Object> params){

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }

    /**
     * 新增分类，返回主键
     * @param type
     * @return
     */
    public boolean insertAndGetId(ProductType type) {

        type.setDeleted(0);
        type.setTypeNum(0);
        int result = this.baseMapper.insertAllColumn(type);
        if (result < 1){
            return false;
        }
        type.setTypeNum(type.getId());
        result = this.baseMapper.updateById(type);
        if (result < 1){
            return false;
        }
        return true;
    }
}
