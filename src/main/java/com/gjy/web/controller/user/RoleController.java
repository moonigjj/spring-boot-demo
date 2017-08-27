package com.gjy.web.controller.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.service.user.RoleService;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(value = "/toadd")
    public String toAdd(){

        return "role/roleAdd";
    }

    @PostMapping(value = "/add")
    public ResultEntity addRole(){

        ResultEntity re = new ResultEntity();

        return re;
    }

    
    @GetMapping(value = "/{roleId:\\d+}/toedit")
    public ModelAndView toEdit(@PathVariable("roleId") Integer roleId){

        ModelAndView mv = new ModelAndView();
        return mv;
    }


    @PostMapping(value = "/edit")
    public ResultEntity editRole(){

        ResultEntity re = new ResultEntity();

        return re;
    }
}
