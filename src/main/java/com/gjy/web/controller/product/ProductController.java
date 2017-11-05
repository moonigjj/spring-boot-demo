package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.model.product.Product;
import com.gjy.model.product.ProductType;
import com.gjy.service.product.*;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@RequestMapping(value = "/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSpecService productSpecService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductUnitService productUnitService;

    @Autowired
    private BrandService brandService;


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
    public String toAdd(Model model){

        model.addAttribute("brands", this.brandService.findAll());
        model.addAttribute("specs", this.productSpecService.findAll());
        model.addAttribute("types", this.productTypeService.findAll());
        model.addAttribute("units", this.productUnitService.findAll());
        return "product/productAdd";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResultEntity add(@Valid Product product){

        ResultEntity re = new ResultEntity();
        boolean result = this.productService.addproduct(product);
        if (result){
            re.setSuccess(true);
        }
        return re;
    }

    @GetMapping(value = "/{productId:\\d+}/del")
    @ResponseBody
    public ResultEntity del(@PathVariable("productId") Integer productId){

        ResultEntity re = new ResultEntity();

        return re;
    }
}
