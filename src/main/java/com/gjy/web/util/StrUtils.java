package com.gjy.web.util;

import org.apache.shiro.util.StringUtils;

/**
 * Created by gaojiajia on 2017/8/9.
 */
public final class StrUtils {

    private StrUtils(){

    }

    /**
     * 判断字符串是否有内容
     * @param str 字符串
     * @return true or false
     */
    public static boolean hasText(String str){

        return StringUtils.hasText(str);
    }

    /**
     * 判断字符串是否为空以及空白符号
     * @param str 字符串
     * @return true or false
     */
    public static boolean nonText(String str){

        return !hasText(str);
    }

    /**
     * 判断是否数字字符串
     * @param str 字符串
     * @return true or false
     */
    public static boolean isDigit(String str){

        if (nonText(str)){

            return false;
        }
        for (int i = 0, len = str.length(); i < len; i++){

            if (!Character.isDigit(str.charAt(i))){

                return false;
            }
        }
        return true;
    }
}
