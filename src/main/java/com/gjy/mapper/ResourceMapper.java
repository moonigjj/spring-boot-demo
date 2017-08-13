package com.gjy.mapper;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.Resource;

import java.util.List;
import java.util.Map;

public interface ResourceMapper extends SuperMapper<Resource> {

    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<Resource> selectListPage(Pagination page, Map<String, Object> params);

}