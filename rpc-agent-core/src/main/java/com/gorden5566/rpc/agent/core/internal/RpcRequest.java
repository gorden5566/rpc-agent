package com.gorden5566.rpc.agent.core.internal;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class RpcRequest {

    /**
     * 接口
     */
    private String serviceName;

    /**
     * 方法
     */
    private String methodName;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 请求参数类型
     */
    private String paramTypes;

    /**
     * 请求id
     */
    private String reqId;

    /**
     * rpc id
     */
    private String rpcId;

    /**
     * tag
     */
    private String tag;

    /**
     * request timeOut
     */
    private Integer timeOut;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(String paramTypes) {
        this.paramTypes = paramTypes;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getRpcId() {
        return rpcId;
    }

    public void setRpcId(String rpcId) {
        this.rpcId = rpcId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }
}
