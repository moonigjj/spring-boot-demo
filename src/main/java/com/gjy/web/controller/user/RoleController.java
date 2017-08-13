package com.gjy.web.controller.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.service.user.RoleService;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:RoleController
 *
 * @author ty
 * @description
 * @create 2017/7/14 15:26
 **/
@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String getList(){

        return "role/roleList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return roleService.findListPage(page, model.asMap());
    }


    @PostMapping(value = "/add")
    public ResultEntity addRole(){

        ResultEntity re = new ResultEntity();

        return re;
    }

    @PostMapping(value = "/edit")
    public ResultEntity editRole(){

        ResultEntity re = new ResultEntity();

        return re;
    }
}
