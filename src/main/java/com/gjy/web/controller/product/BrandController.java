package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;
import com.gjy.model.product.Brand;
import com.gjy.service.product.BrandService;
import com.gjy.web.filter.PageContext;
import com.gjy.web.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by gaojiajia on 2017/8/27.
 */
@RequestMapping(value = "/brand")
@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

//    @ModelAttribute
//    public


    @GetMapping
    public String getList(){

        return "product/brand/brandList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        Page<Brand> brands= brandService.findListPage(page, model.asMap());
        return brands;
    }

    @GetMapping(value = "/toadd")
    public String toAdd(){

        return "product/brand/brandAdd";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResultEntity add(@Valid Brand brand){

        ResultEntity re = new ResultEntity();
        Brand brand1 = this.brandService.getBrandByName(brand.getName());
        if (brand1 != null){
            re.setCode(IExceptionMdgEnum.ProductCode.BRAND_NAME_EXIST.getCode());
            re.setMsg(IExceptionMdgEnum.ProductCode.BRAND_NAME_EXIST.getMessage());
            return re;
        }
        boolean result = this.brandService.insertAndGetId(brand);
        ResultUtils.callback(result, re);
        return re;
    }

    @GetMapping(value = "/{brandId:\\d+}/del")
    @ResponseBody
    public ResultEntity del(@PathVariable("brandId") Integer brandId){

        ResultEntity re = new ResultEntity();
        Brand brand = this.brandService.getBrand(brandId);
        if (brand == null){
            re.setCode(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getCode());
            re.setMsg(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getMessage());
            return  re;
        }
        brand.setDeleted(1);
        boolean result = this.brandService.updateById(brand);
        ResultUtils.callback(result, re);
        return re;
    }

}
