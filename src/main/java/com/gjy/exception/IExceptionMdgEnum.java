package com.gjy.exception;

/**
 * InterfaceName:IExceptionMdgEnum
 *
 * @author ty
 * @description 异常信息枚举
 * @create 2017/7/18 20:25
 **/
public interface IExceptionMdgEnum {

    Integer SUCCESS_CODE = 1;//成功标示
    Integer FAIL_CODE = 0;//失败标示

    String SUC_MSG = "操作成功";
    String FAIL_MSG = "操作失败";

    enum SystemCode{

        SYS_ERROR(100000, "系统异常"),
        SUBMIT_PARAMS(100001, "提交参数不合理")
        ;
        private Integer code;
        private String message;

        SystemCode(Integer code, String message){

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

    /**
     * 用户模块
     */
    enum UserCode{

        USERNAME_OR_PASSWORD_NOT_EMPTY(101001, "用户名或密码不能为空"),
        USERNAME_OR_PASSWORD_NOT_CORRECT(101002,"用户名或密码不正确"),
        USER_NAME_EXIST(101003, "用户名已存在")
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

    /**
     * 商品模块
     */
    enum ProductCode{
        BRAND_NAME_EXIST(102001, "品牌名称已存在"),
        PRODUCT_SPEC_NAME_EXIST(102002, "规格名称已存在"),
        PRODUCT_TYPE_NAME_EXIST(102003, "分类名称已存在"),
        PRODUCT_UNIT_NAME_EXIST(102004, "计量单位名称已存在"),
        PRODUCT_NAME_EXIST(102005, "商品名称已存在"),
        ;
        private Integer code;
        private String message;

        ProductCode(Integer code, String message){

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
