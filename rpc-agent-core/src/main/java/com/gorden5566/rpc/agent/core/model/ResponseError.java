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

    public ResponseError(String msg, String cause) {
        this.msg = msg;
        this.cause = cause;
    }

    public static ResponseError newError(String msg, String cause, int status) {
        ResponseError error = new ResponseError();
        error.setCause(cause);
        error.setMsg(msg);
        error.setStatus(status);
        return error;
    }

    public static ResponseError newThrowableError(String msg, Throwable cause, int status) {
        ResponseError error = new ResponseError();
        error.setCause(ExceptionUtils.getFullStackTrace(cause));
        error.setMsg(msg);
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

