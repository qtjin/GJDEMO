package com.gj.gjlibrary.base;

import java.io.Serializable;

/**
 * Created by guojing on 2016/2/17.
 * 基础实体类
 */
public class BaseBean<T> implements Serializable {
    public int success;
    public String msg;
    public T data;

    public int error_code;
    public String error;
    public String url;
}
