package com.gjy.web.controller.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.service.user.PermissionService;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:PremissionController
 *
 * @author ty
 * @description
 * @create 2017/7/18 20:46
 **/
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public String getLIst(){

        return "permission/permissionList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return permissionService.findListPage(page);
    }

    @PostMapping(value = "/add")
    public ResultEntity addPremission(){

        ResultEntity re = new ResultEntity();

        return re;
    }

    @PostMapping(value = "/edit")
    public ResultEntity editPremission(){

        ResultEntity re = new ResultEntity();

        return re;
    }
}
