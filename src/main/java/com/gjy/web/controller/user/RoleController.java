package com.gjy.web.controller.user;

import com.gjy.common.ResultEntity;
import com.gjy.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping(value = "/list")
    public Object getListPage(){

        return null;
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
