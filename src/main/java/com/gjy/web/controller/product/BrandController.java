package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.service.product.BrandService;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@RequestMapping(value = "/brand")
@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;


    @GetMapping
    public String getList(){

        return "product/brand/brandList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return brandService.findListPage(page, model.asMap());
    }

    @GetMapping(value = "/toadd")
    public String toAdd(){

        return "product/brand/brandAdd";
    }

    @PostMapping(value = "/add")
    public ResultEntity add(){

        ResultEntity re = new ResultEntity();

        return re;
    }

    @GetMapping(value = "/{brandId:\\d+}/del")
    public ResultEntity del(@PathVariable("brandId") Integer brandId){

        ResultEntity re = new ResultEntity();

        return re;
    }

}
