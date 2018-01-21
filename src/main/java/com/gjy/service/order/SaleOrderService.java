package com.gjy.service.order;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.order.SaleOrderMapper;
import com.gjy.model.order.SaleOrder;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderService extends ServiceImpl<SaleOrderMapper, SaleOrder> {
}
