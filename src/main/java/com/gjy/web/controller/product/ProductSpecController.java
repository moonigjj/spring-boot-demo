package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;
import com.gjy.model.product.ProductSpec;
import com.gjy.service.product.ProductSpecService;
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
    @ResponseBody
    public ResultEntity add(@Valid ProductSpec spec){

        ResultEntity re = new ResultEntity();
        ProductSpec productSpec = this.productSpecService.getProductSpecByName(spec.getName());
        if (productSpec != null){
            re.setCode(IExceptionMdgEnum.ProductCode.PRODUCT_SPEC_NAME_EXIST.getCode());
            re.setMsg(IExceptionMdgEnum.ProductCode.PRODUCT_SPEC_NAME_EXIST.getMessage());
            return re;
        }
        boolean result = this.productSpecService.addProductSpec(spec);
        ResultUtils.callback(result, re);
        return re;
    }

    @GetMapping(value = "/{specId:\\d+}/del")
    @ResponseBody
    public ResultEntity del(@PathVariable("specId") Integer specId){

        ResultEntity re = new ResultEntity();
        ProductSpec productSpec = this.productSpecService.getProductSpec(specId);
        if (productSpec == null){
            re.setCode(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getCode());
            re.setMsg(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getMessage());
            return  re;
        }
        productSpec.setDeleted(1);
        boolean result = this.productSpecService.updateById(productSpec);
        ResultUtils.callback(result, re);
        return re;
    }
}
