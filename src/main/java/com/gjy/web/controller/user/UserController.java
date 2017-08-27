package com.gjy.web.controller.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;
import com.gjy.model.UserAdmin;
import com.gjy.service.user.UserAdminService;
import com.gjy.web.filter.PageContext;
import com.gjy.web.util.EncryptUtils;
import com.gjy.web.util.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    @GetMapping(value = "/toadd")
    public String toAdd(){

        return "user/userAdd";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ResultEntity addUser(@Valid UserAdmin userAdmin){

        ResultEntity re = new ResultEntity();
        UserAdmin user = this.userService.findByName(userAdmin.getUserName());
        if (user != null){

            re.setCode(IExceptionMdgEnum.UserCode.USER_NAME_EXIST.getCode());
            re.setMsg(IExceptionMdgEnum.UserCode.USER_NAME_EXIST.getMessage());
            return re;
        }
        userAdmin.setDeleted(0);
        userAdmin.setStatus(0);
        String salt = EncryptUtils.getRandomCharAndNum(16);
        userAdmin.setSalt(salt);
        userAdmin.setPassword(EncryptUtils.md5Hex(userAdmin.getPassword(), salt));
        boolean isSuc = this.userService.insertAllColumn(userAdmin);
        if (isSuc){

            re.setSuccess(isSuc);
        }
        return re;
    }

    @GetMapping(value = "/{uid:\\d+}/toEdit")
    public ModelAndView toEdit(@PathVariable("uid") Integer uid){

        ModelAndView mv = new ModelAndView();
        UserAdmin userAdmin = this.userService.selectById(uid);
        if (userAdmin != null){

            mv.setViewName("user/userEdit");
            mv.addObject("user", userAdmin);
        } else {

            mv.setViewName("404");
        }
        return mv;
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public ResultEntity editUser(@Valid UserAdmin userAdmin){

        ResultEntity re = new ResultEntity();
        if (!StrUtils.isDigit(userAdmin.getId().toString())){

            re.setCode(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getCode());
            re.setMsg(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getMessage());
            return re;
        }
        UserAdmin user = this.userService.selectById(userAdmin.getId());
        if (user == null){

            re.setCode(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getCode());
            re.setMsg(IExceptionMdgEnum.SystemCode.SUBMIT_PARAMS.getMessage());
            return re;
        }
        String salt = EncryptUtils.getRandomCharAndNum(16);
        userAdmin.setSalt(salt);
        userAdmin.setPassword(EncryptUtils.md5Hex(userAdmin.getPassword(), salt));
        boolean isSuc = this.userService.updateById(userAdmin);
        if (isSuc){

            re.setSuccess(true);
        }
        return re;
    }

    @PostMapping(value = "/{uid:\\d+}/del")
    @ResponseBody
    public ResultEntity delUser(@PathVariable("uid") Integer uid){

        ResultEntity re = new ResultEntity();

        return re;
    }

}
