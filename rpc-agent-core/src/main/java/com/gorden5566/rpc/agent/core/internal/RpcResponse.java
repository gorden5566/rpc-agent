package com.gorden5566.rpc.agent.core.internal;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class RpcResponse {
    private static final int SUCCESS = 200;
    private transient int status;
    private String msg;
    private String cause;
    private Object data;

    public static RpcResponse newError(String msg, String cause) {
        RpcResponse response = new RpcResponse();
        response.setCause(cause);
        response.setMsg(msg);
        response.setStatus(400);
        return response;
    }

    public static RpcResponse newThrowableError(String msg, Throwable cause) {
        RpcResponse response = new RpcResponse();
        response.setCause(ExceptionUtils.getFullStackTrace(cause));
        response.setMsg(msg);
        response.setStatus(400);
        return response;
    }

    public static RpcResponse newSuccess(Object data) {
        RpcResponse response = new RpcResponse();
        response.setStatus(SUCCESS);
        response.setData(data);
        return response;
    }

    public static boolean isSuccess(RpcResponse response) {
        return response != null && response.getStatus() == SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
