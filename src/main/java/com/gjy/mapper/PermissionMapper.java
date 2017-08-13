package com.gjy.mapper;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.Permission;

import java.util.List;

public interface PermissionMapper extends SuperMapper<Permission> {

    /**
     * 分页列表查询
     * @param page 分页对象
     * @return
     */
    List<Permission> selectListPage(Pagination page);

}