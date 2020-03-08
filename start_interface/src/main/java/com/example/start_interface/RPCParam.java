package com.example.start_interface;

import java.io.Serializable;

public class RPCParam implements Serializable {
    private String clazzName;
    private String methodName;
    private Object[] params;
    private Class<?>[] paramTypes;

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public void initParams(int size){
        params = new Object[size];
        paramTypes = new Class[size];
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }
}
