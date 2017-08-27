package com.gjy.web.controller.login;

import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(value = "/login")
    public String getLogin(){

        return "login";
    }

    /**
     * 登录请求
     * @param username 用户名
     * @param password 登录密码
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password){

        ResultEntity re = new ResultEntity();
        if (null == username || null == password){

            re.setCode(IExceptionMdgEnum.UserCode.USERNAME_OR_PASSWORD_NOT_EMPTY.getCode());
            re.setMsg(IExceptionMdgEnum.UserCode.USERNAME_OR_PASSWORD_NOT_EMPTY.getMessage());
            return re;
        }

        try {

            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            re.setSuccess(true);
        } catch (AccountException ex){

            re.setCode(IExceptionMdgEnum.UserCode.USERNAME_OR_PASSWORD_NOT_EMPTY.getCode());
            re.setMsg(IExceptionMdgEnum.UserCode.USERNAME_OR_PASSWORD_NOT_EMPTY.getMessage());
        } catch (Exception e){

            logger.error("login error >>> {}", e.getMessage());
            re.setCode(IExceptionMdgEnum.SystemCode.SYS_ERROR.getCode());
            re.setMsg(IExceptionMdgEnum.SystemCode.SYS_ERROR.getMessage());
            e.printStackTrace();
        }
        return re;
    }

}
