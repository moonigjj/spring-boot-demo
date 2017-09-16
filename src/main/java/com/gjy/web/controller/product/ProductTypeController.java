package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;
import com.gjy.model.product.ProductType;
import com.gjy.service.product.ProductTypeService;
import com.gjy.web.filter.PageContext;
import com.gjy.web.util.ResultUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 商品分类控制层
 * Created by gaojiajia on 2017/8/26.
 */
@RequestMapping(value = "/product/type")
@Controller
@Log4j2
public class ProductTypeController {
    
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public String getList(){

        return "product/type/productTypeList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return productTypeService.findListPage(page, model.asMap());
    }

    @GetMapping(value = "/toadd")
    public String toAdd(){

        return "product/type/productTypeAdd";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResultEntity add(@Valid ProductType type){

        ResultEntity re = new ResultEntity();
        ProductType productType = this.productTypeService.getProductTypeByName(type.getName());
        if (productType != null){
            re.setCode(IExceptionMdgEnum.ProductCode.PRODUCT_TYPE_NAME_EXIST.getCode());
            re.setMsg(IExceptionMdgEnum.ProductCode.PRODUCT_TYPE_NAME_EXIST.getMessage());
            return re;
        }
        boolean result = this.productTypeService.insertAndGetId(type);
        ResultUtils.callback(result, re);
        return re;
    }

    @GetMapping(value = "/{typeId:\\d+}/del")
    @ResponseBody
    public ResultEntity del(@PathVariable("typeId") Integer typeId){

        ResultEntity re = new ResultEntity();
        ProductType productType = this.productTypeService.getProductType(typeId);
        if (productType == null){
            re.setCode(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getCode());
            re.setMsg(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getMessage());
            return  re;
        }
        productType.setDeleted(1);
        boolean result = this.productTypeService.updateById(productType);
        ResultUtils.callback(result, re);
        return re;
    }
}
