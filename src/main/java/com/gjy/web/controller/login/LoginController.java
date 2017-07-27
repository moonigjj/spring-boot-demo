package com.gjy.web.controller.login;

import com.gjy.common.ResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:LoginController
 *
 * @author ty
 * @description
 * @create 2017/7/13 9:38
 **/
@Controller
public class LoginController {


    @GetMapping(value = "/login")
    public String getLogin(){

        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password){

        ResultEntity re = new ResultEntity();

        if (null == username || null == password){


        }
        return re;
    }

}
