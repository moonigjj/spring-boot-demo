package com.gjy.web.advice;


import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * ClassName:ControllerAdvice
 *
 * @author ty
 * @description
 * @create 2017/7/7 15:38
 **/
@ControllerAdvice
public class ControllerAdviceHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAdviceHandler.class);

    /**
     * 处理未知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception e){

        logger.error("advice handler exception >>> {}", e.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error/500");
        return mv;
    }

}
