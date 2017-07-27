package com.gjy.exception;

/**
 * InterfaceName:IExceptionMdgEnum
 *
 * @author ty
 * @description 异常信息枚举
 * @create 2017/7/18 20:25
 **/
public interface IExceptionMdgEnum {

    /**
     * 用户模块
     */
    enum UserCode{

        USERNAME_OR_PASSWORD_NOT_CORRECT(100001,"用户名或密码不正确")
        ;
        private Integer code;
        private String message;

        UserCode(Integer code, String message){

            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
