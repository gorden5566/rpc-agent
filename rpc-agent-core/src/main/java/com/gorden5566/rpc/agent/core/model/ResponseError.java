package com.gorden5566.rpc.agent.core.model;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class ResponseError {
    private transient int status;
    private String msg;
    private String cause;

    public ResponseError() {
    }

    public static ResponseError newInstance(String msg, Throwable cause, int status) {
        ResponseError error = new ResponseError();
        error.setMsg(msg);
        error.setCause(ExceptionUtils.getFullStackTrace(cause));
        error.setStatus(status);

        return error;
    }

    public static ResponseError newInstance(String msg, String cause, int status) {
        ResponseError error = new ResponseError();
        error.setMsg(msg);
        error.setCause(cause);
        error.setStatus(status);

        return error;
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
}

