package com.gjy.exception;

/**
 * ClassName:UserException
 *
 * @author ty
 * @description 自定义异常基类
 * @create 2017/7/7 15:46
 **/
public class UserException extends RuntimeException {

    private Integer code;

    public UserException(Integer code,String message){

        super(message);
        this.code = code;
    }

    public UserException(Integer code, Throwable cause){

        super(cause);
        this.code = code;
    }

    public UserException(Integer code,String message, Throwable cause){

        super(message, cause);
        this.code = code;
    }
}
