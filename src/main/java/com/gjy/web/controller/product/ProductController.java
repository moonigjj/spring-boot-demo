package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.service.product.ProductService;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@RequestMapping(value = "/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public String getList(){

        return "product/productList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return productService.findListPage(page, model.asMap());
    }

    @GetMapping(value = "/toadd")
    public String toAdd(){

        return "product/productAdd";
    }

    @PostMapping(value = "/add")
    public ResultEntity add(){

        ResultEntity re = new ResultEntity();

        return re;
    }

    @GetMapping(value = "/{productId:\\d+}/del")
    public ResultEntity del(@PathVariable("productId") Integer productId){

        ResultEntity re = new ResultEntity();

        return re;
    }
}
