package com.gjy.web.controller.user;

import com.gjy.common.ResultEntity;
import com.gjy.service.user.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:UserController
 *
 * @author ty
 * @description
 * @create 2017/7/13 9:39
 **/
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserAdminService userService;

    @GetMapping(value = "/list")
    public Object getListPage(){

        return null;
    }

    @PostMapping(value = "/add")
    public ResultEntity addUser(){

        ResultEntity re = new ResultEntity();

        return re;
    }

    @PostMapping(value = "/edit")
    public ResultEntity editUser(){

        ResultEntity re = new ResultEntity();

        return re;
    }

}
