package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.product.BrandMapper;
import com.gjy.model.product.Brand;
import com.gjy.web.util.StrUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Service
@Slf4j
public class BrandService extends ServiceImpl<BrandMapper, Brand> {

    /**
     * 通过id查询
     * @param brandId
     * @return
     */
    @Cacheable(value = "baseCache", unless = "#result == null", key = "'brand' + #brandId")
    public Brand getBrand(Integer brandId){
        if (brandId == null){
            return null;
        }
        return this.baseMapper.selectById(brandId);
    }

    /**
     * 通过商品名称查询
     * @param brandName 商品名称
     * @return
     */
    @Cacheable(value = "baseCache", unless = "#result == null", key = "'brand' + #brandName")
    public Brand getBrandByName(String brandName){
        if (StrUtils.isNullOrEmpty(brandName)){
            return null;
        }
        return this.baseMapper.selectByName(brandName);
    }

    
    /**
     * 分页列表查询
     * @param page 分页对象
     * @param params 条件参数
     * @return
     */
    public Page<Brand> findListPage(Page<Brand> page, Map<String, Object> params){

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }

    /**
     * 插入更新编号
     * @param brand
     * @return true or false
     */
    @Transactional
    public boolean insertAndGetId(Brand brand){

        brand.setDeleted(0);
        brand.setBrandNum(0);
        int result = this.baseMapper.insertAllColumn(brand);
        log.info("insert brand result - {}", result);
        brand.setBrandNum(brand.getId());
        result = this.baseMapper.updateById(brand);
        log.info("update brand result - {}", result);
        return true;
    }

    /**
     * 查询所有未删除的
     * @return
     */
    public List<Brand> findAll(){

        return this.baseMapper.selectAllBrand();
    }
}
