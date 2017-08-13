package com.gjy.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.PermissionMapper;
import com.gjy.model.Permission;
import org.springframework.stereotype.Service;

/**
 * ClassName:PremissionService
 *
 * @author ty
 * @description
 * @create 2017/7/7 15:33
 **/
@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> {

    /**
     * 分页列表查询
     * @param page 分页对象
     * @return
     */
    public Page<Permission> findListPage(Page<Permission> page){

        page.setRecords(this.baseMapper.selectListPage(page));
        return page;
    }
}
