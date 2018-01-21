package com.gjy.web.controller.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.model.order.BuyOrder;
import com.gjy.service.order.BuyOrderService;
import com.gjy.service.product.ProductService;
import com.gjy.web.filter.PageContext;
import com.gjy.web.util.SnowflakeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gaojiajia on 2017/9/21.
 */
@RequestMapping("/buy/order")
@Controller
public class BuyOrderController {
    
    @Autowired
    private BuyOrderService buyOrderService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getList(){

        return "order/buyOrderList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return buyOrderService.findListPage(page, model.asMap());
    }

    @GetMapping(value = "/toadd")
    public String toAdd(Model model){

        model.addAttribute("product", this.productService.findAll());
        return "order/buyOrderAdd";
    }

    @PostMapping(value = "/add")
    public ResultEntity addBuyOrder(@Validated BuyOrder buyOrder){

        ResultEntity re = new ResultEntity();
        buyOrder.setOrderId("b" + SnowflakeId.getInstance().getLongBinaryString());
        this.buyOrderService.insertAllColumn(buyOrder);
        return re;
    }


    @GetMapping(value = "/{orderId:\\d+}/toedit")
    public ModelAndView toEdit(@PathVariable("orderId") Integer orderId){

        ModelAndView mv = new ModelAndView();
        this.buyOrderService.selectById(orderId);
        return mv;
    }


    @PostMapping(value = "/edit")
    public ResultEntity editBuyOrder(){

        ResultEntity re = new ResultEntity();

        return re;
    }
}
