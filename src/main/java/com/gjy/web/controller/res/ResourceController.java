package com.gjy.web.controller.res;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.service.resource.ResourceService;
import com.gjy.web.filter.PageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gaojiajia on 2017/8/10.
 */
@RequestMapping(value = "/res")
@Controller
public class ResourceController {

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public String getList(){

        return "res/resList";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Object getListPage(Model model){

        Page page = new Page(PageContext.getOffSet(), PageContext.getPageSize());
        return resourceService.findListPage(page, model.asMap());
    }
}
