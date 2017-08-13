package com.gjy.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends SuperMapper<Role> {

    /**
     * 查询用户的角色
     * @param userId 用户id
     * @return 角色列表
     */
    List<Role> selectByUserId(@Param("userId") Integer userId);

    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<Role> selectListPage(Pagination page, Map<String, Object> params);

}