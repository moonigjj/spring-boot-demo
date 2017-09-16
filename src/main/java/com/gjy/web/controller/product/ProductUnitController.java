package com.gjy.web.controller.product;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;
import com.gjy.model.product.ProductUnit;
import com.gjy.service.product.ProductUnitService;
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
        ProductUnit productUnit = this.productUnitService.getProductUnitByName(unit.getName());
        if (productUnit != null){
            re.setCode(IExceptionMdgEnum.ProductCode.PRODUCT_UNIT_NAME_EXIST.getCode());
            re.setMsg(IExceptionMdgEnum.ProductCode.PRODUCT_UNIT_NAME_EXIST.getMessage());
            return re;
        }
        boolean result = this.productUnitService.addProductUnit(unit);
        ResultUtils.callback(result, re);
        return re;
    }

    @GetMapping(value = "/{unitId:\\d+}/del")
    @ResponseBody
    public ResultEntity del(@PathVariable("unitId") Integer unitId){

        ResultEntity re = new ResultEntity();
        ProductUnit productUnit = this.productUnitService.getProductUnit(unitId);
        if (productUnit == null){
            re.setCode(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getCode());
            re.setMsg(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getMessage());
            return  re;
        }
        productUnit.setDeleted(1);
        boolean result = this.productUnitService.updateById(productUnit);
        ResultUtils.callback(result, re);
        return re;
    }
}
