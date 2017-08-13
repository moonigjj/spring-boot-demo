package com.gjy.mapper;

import com.gjy.common.SuperMapper;
import com.gjy.model.RolePermission;

import java.util.List;

/**
 * Created by gaojiajia on 2017/8/9.
 */
public interface RolePermissionMapper extends SuperMapper<RolePermission> {

    /**
     * 通过角色ids查询权限
     * @param roleIds 角色id数组
     * @return 角色权限关联列表
     */
    List<RolePermission> selectByRoleIds(Integer[] roleIds);
}
