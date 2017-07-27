package com.gjy.web.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * ClassName:EncryptUtils
 *
 * @author ty
 * @description 加密工具类
 * @create 2017/7/13 15:48
 **/
public final class EncryptUtils {

    /**
     * md5加密
     * @param password 密码 salt 盐
     * @return
     */
    public static String md5Hex(String password, String salt){

        if (null == password){

            return null;
        }
        return DigestUtils.md5Hex(password + salt);
    }

    /**
     * 获取随机字母数字组合
     * @param length 字符串长度
     * @return
     */
    public static String getRandomCharAndNum(int length){

        StringBuffer str = new StringBuffer("");
        Random random = new Random();
        boolean b;
        for (int i = 0; i < length; i++){

            b = random.nextBoolean();
            if (b){

                str.append((char)(65 + random.nextInt(26)));
            } else {

                str.append(random.nextInt(10));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

        System.out.println(getRandomCharAndNum(16));
    }
}
