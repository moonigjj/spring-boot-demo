package com.gjy.web.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by gaojiajia on 2017/8/9.
 */
public final class GsonUtils {

    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    private GsonUtils(){

    }

    /**
     * JSON字符串转换为List数组, 提供两种方式(主要解决调用的容易程度)
     * @param json 内容
     * @param token 参数转换
     * @param <T>
     * @return
     */
    public static <T> List<T> convertList(String json, TypeToken<List<T>> token){

        if (StrUtils.nonText(json)){

            return new ArrayList<T>();
        }
        return gson.fromJson(json, token.getType());
    }

    /**
     * 由JSON字符串转化到制定类型T
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T convertObj(String json, Class<T> clz){

        if (StrUtils.nonText(json)){

            return null;
        }
        return gson.fromJson(json, clz);
    }

    /**
     * java对象转化JSON
     * @param obj
     * @return
     */
    public static String toJson(Object obj){

        if (Objects.isNull(obj)){

            return "";
        }
        return gson.toJson(obj);
    }

}
