package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.model.product.ProductUnit;
import com.gjy.service.product.ProductUnitService;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@RequestMapping(value = "/product/unit")
@Controller
public class ProductUnitController {

    @Autowired
    private ProductUnitService productUnitService;

    @GetMapping
    public String getList(){

        return "product/unit/productUnitList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return productUnitService.findListPage(page, model.asMap());
    }

    @GetMapping(value = "/toadd")
    public String toAdd(){

        return "product/unit/productUnitAdd";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResultEntity add(@Valid ProductUnit unit){

        ResultEntity re = new ResultEntity();
        boolean result = this.productUnitService.addProductUnit(unit);
        if (result){
            re.setSuccess(true);
        }
        return re;
    }

    @GetMapping(value = "/{unitId:\\d+}/del")
    @ResponseBody
    public ResultEntity del(@PathVariable("unitId") Integer unitId){

        ResultEntity re = new ResultEntity();

        return re;
    }
}
