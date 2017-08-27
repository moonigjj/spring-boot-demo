package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.service.product.ProductSpecService;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@Controller
@RequestMapping(value = "/product/spec")
public class ProductSpecController {

    @Autowired
    private ProductSpecService productSpecService;

    @GetMapping
    public String getList(){

        return "product/spec/productSpecList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return productSpecService.findListPage(page, model.asMap());
    }

    @GetMapping(value = "/toadd")
    public String toAdd(){

        return "product/spec/productSpecAdd";
    }

    @PostMapping(value = "/add")
    public ResultEntity add(){

        ResultEntity re = new ResultEntity();

        return re;
    }

    @GetMapping(value = "/{specId:\\d+}/del")
    public ResultEntity del(@PathVariable("specId") Integer specId){

        ResultEntity re = new ResultEntity();

        return re;
    }
}
