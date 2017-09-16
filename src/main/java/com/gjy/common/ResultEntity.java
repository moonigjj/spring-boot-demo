package com.gjy.common;

import com.gjy.exception.IExceptionMdgEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:ResultEntity
 *
 * @author ty
 * @description 统一返回对象
 * @create 2017/7/13 9:42
 **/
@Data
public class ResultEntity<T> implements Serializable {

    private Integer code;

    private String msg = IExceptionMdgEnum.FAIL_MSG;

    private boolean success = false;

    private T data;

}
