package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.dto.ProductDTO;
import com.gjy.mapper.product.ProductMapper;
import com.gjy.model.product.Product;
import com.gjy.web.util.StrUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> {

    /**
     * 通过id查询
     * @param productId
     * @return
     */
    @Cacheable(value = "baseCache", unless = "#result == null", key = "'product' + #productId")
    public Product getProduct(Integer productId){
        if (productId == null){
            return null;
        }
        return this.baseMapper.selectById(productId);
    }

    /**
     * 通过产品名称查询
     * @param productName 产品名称
     * @return
     */
    @Cacheable(value = "baseCache", unless = "#result == null", key = "'product' + #brandName")
    public Product getProductByName(String productName){
        if (StrUtils.isNullOrEmpty(productName)){
            return null;
        }
        return this.baseMapper.selectByName(productName);
    }

    /**
     * 分页列表查询
     * @param page 分页对象
     * @param params 条件参数
     * @return
     */
    public Page<ProductDTO> findListPage(Page<ProductDTO> page, Map<String, Object> params){

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }

    @Transactional
    public boolean addproduct(Product product) {

        int result = this.baseMapper.insertAllColumn(product);
        if (result < 1){
            return false;
        }
        return true;
    }

    /**
     * 查询所有未删除的
     * @return
     */
    public List<Product> findAll(){

        return this.baseMapper.selectAllProduct();
    }
}
