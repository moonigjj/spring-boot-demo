package com.gjy.service.role;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.RolePermissionMapper;
import com.gjy.model.RolePermission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by gaojiajia on 2017/8/9.
 */
@Service
public class RolePermissionService extends ServiceImpl<RolePermissionMapper, RolePermission> {

    /**
     * 通过角色ids查询权限
     * @param roleIds 角色id数组
     * @return 角色权限关联列表
     */
    public List<RolePermission> findByRoleIds(Integer[] roleIds){

        if (Objects.isNull(roleIds) || roleIds.length == 0){

            return null;
        }
        return this.baseMapper.selectByRoleIds(roleIds);
    }
}
