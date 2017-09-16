package com.gjy.web.util;

import com.google.common.base.Strings;
import org.apache.shiro.util.StringUtils;

/**
 * Created by gaojiajia on 2017/8/9.
 */
public final class StrUtils {

    private StrUtils(){

    }

    /**
     * 是否非null,非空
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str){

        return Strings.isNullOrEmpty(str);
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

    /**
     * 向前填充字符串
     * ("1",'0',4) -> '00001'
     * @param str 字符串
     * @param charSequence 填充的字符
     * @param len 填充位数
     * @return
     */
    public static String preFill(String str, CharSequence charSequence, int len){

        if (str == null || charSequence == null || len == 0){

            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++){
            sb.append(charSequence);
        }
        sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.printf(preFill("1", "0", 4));
    }
}
