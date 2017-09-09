package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.product.BrandMapper;
import com.gjy.model.product.Brand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Service
public class BrandService extends ServiceImpl<BrandMapper, Brand> {

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
        if (result < 1){
            return false;
        }
        brand.setBrandNum(brand.getId());
        result = this.baseMapper.updateById(brand);
        if (result < 1){
            return false;
        }
        return true;
    }
}
