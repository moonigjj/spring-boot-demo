package com.gjy.web.filter;

/**
 * ClassName:PageContext
 *
 * @author ty
 * @description ThreadLocal封装offSet和pageSize
 * @create 2017/7/11 14:07
 **/
public class PageContext {

    //定义两个threadLocal变量：offSet和pageSize
    private static ThreadLocal<Integer> offSet = new ThreadLocal<>();
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<>();

    public static int getOffSet(){

        Integer os = offSet.get();
        if (os == null){

            return 0;
        }
        return os;
    }

    public static void setOffSet(int offSetValue){

        offSet.set(offSetValue);
    }

    public static void removeOffSet(){

        offSet.remove();
    }


    public static int getPageSize(){

        Integer ps = pageSize.get();
        if (ps == null){

            return 0;
        }
        return ps;
    }

    public static void setPageSize(int pageSizeValue){

        pageSize.set(pageSizeValue);
    }

    public static void removePageSize(){

        pageSize.remove();
    }
}
