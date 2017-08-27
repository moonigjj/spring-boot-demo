package com.gjy.service.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.product.BrandMapper;
import com.gjy.model.product.Brand;
import org.springframework.stereotype.Service;

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
}
