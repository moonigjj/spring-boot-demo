package com.gjy.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gaojiajia on 2017/8/9.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/index")
    public String index(){

        return "index";
    }

    @GetMapping(value = "/welcome")
    public String welcome(){

        return "index/welcome";
    }

    @GetMapping(value = "/403")
    public String auth(){

        return "error/403";
    }

    @GetMapping(value = "/404")
    public String error404(){

        return "error/404";
    }

    @GetMapping(value = "/500")
    public String error500(){

        return "error/500";
    }
}
