package com.gjy.web.advice;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:ControllerAdvice
 *
 * @author ty
 * @description
 * @create 2017/7/7 15:38
 **/
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ModelAttribute
    public void addCommonMode(Model model, HttpServletRequest request){


    }

}
