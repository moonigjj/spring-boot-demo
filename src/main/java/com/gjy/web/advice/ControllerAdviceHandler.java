package com.gjy.web.advice;


import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;


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
    @ResponseBody
    public Object handlerException(Exception e){

        logger.error("advice handler exception >>> {}", e.getMessage());
        ResultEntity re = new ResultEntity();
        re.setCode(IExceptionMdgEnum.UserCode.USERNAME_OR_PASSWORD_NOT_EMPTY.getCode());
        re.setMsg(IExceptionMdgEnum.UserCode.USERNAME_OR_PASSWORD_NOT_EMPTY.getMessage());
        return re;
    }

}
