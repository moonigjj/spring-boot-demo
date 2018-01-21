package com.gjy.mapper.order;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gjy.common.SuperMapper;
import com.gjy.model.order.BuyOrder;

import java.util.List;
import java.util.Map;

public interface BuyOrderMapper extends SuperMapper<BuyOrder> {

    /**
     * 分页列表查询
     * @param page 分页对象 params 条件参数
     * @return
     */
    List<BuyOrder> selectListPage(Pagination page, Map<String, Object> params);
}
