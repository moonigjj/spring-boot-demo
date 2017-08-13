package com.gjy.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.UserAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserAdminMapper extends SuperMapper<UserAdmin> {

    /**
     * 通过用户名查询
     * @param username 用户名
     * @return 用户对象
     */
    UserAdmin selectByName(@Param("username") String username);


    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<UserAdmin> selectListPage(Pagination page, Map<String, Object> params);
}