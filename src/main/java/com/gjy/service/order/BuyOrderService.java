package com.gjy.service.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.order.BuyOrderMapper;
import com.gjy.model.order.BuyOrder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BuyOrderService extends ServiceImpl<BuyOrderMapper, BuyOrder>{

    /**
     * 分页列表查询
     * @param page
     * @param params
     * @return
     */
    public Object findListPage(Page page, Map<String, Object> params) {

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }
}
