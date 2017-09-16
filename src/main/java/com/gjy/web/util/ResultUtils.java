package com.gjy.web.util;

import com.gjy.common.ResultEntity;
import com.gjy.exception.IExceptionMdgEnum;

/**
 * Created by gaojiajia on 2017/9/16.
 */
public final class ResultUtils {

    private ResultUtils(){

    }

    /**
     * 处理返回结果值
     * @param result
     * @param re
     */
    public static void callback(boolean result, ResultEntity re){

        if (result){
            re.setSuccess(true);
            re.setMsg(IExceptionMdgEnum.SUC_MSG);
        }
    }
}
