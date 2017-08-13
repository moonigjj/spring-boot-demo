package com.gjy.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.RoleMapper;
import com.gjy.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RoleService
 *
 * @author ty
 * @description
 * @create 2017/7/7 15:33
 **/
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    /**
     * 查询用户的角色
     * @param userId 用户id
     * @return 角色列表
     */
    public List<Role> findByUserid(Integer userId){

        if (userId == null){

            return null;
        }
        return this.baseMapper.selectByUserId(userId);
    }

    /**
     * 分页列表查询
     * @param page 分页对象
     * @param params 条件参数
     * @return
     */
    public Page<Role> findListPage(Page<Role> page, Map<String, Object> params){

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }
}
