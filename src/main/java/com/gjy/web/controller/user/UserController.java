package com.gjy.web.controller.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.service.user.UserAdminService;
import com.gjy.web.filter.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping
    public String getList(){

        return "user/userList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return userService.findListPage(page, model.asMap());
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
