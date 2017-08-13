package com.gjy.service.resource;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.ResourceMapper;
import com.gjy.model.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by gaojiajia on 2017/8/10.
 */
@Service
public class ResourceService extends ServiceImpl<ResourceMapper, Resource> {

    /**
     * 分页列表查询
     * @param page 分页对象
     * @param params 条件参数
     * @return
     */
    public Page<Resource> findListPage(Page<Resource> page, Map<String, Object> params){

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }
}
