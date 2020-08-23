package com.gorden5566.rpc.agent.core.internal;

import com.alibaba.fastjson.JSONArray;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class RpcRequestConfig {
    private String host;
    private Integer port;
    private String service;
    private String method;
    private String tag;
    private JSONArray params;
    private JSONArray paramTypes;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public JSONArray getParams() {
        return params;
    }

    public void setParams(JSONArray params) {
        this.params = params;
    }

    public JSONArray getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(JSONArray paramTypes) {
        this.paramTypes = paramTypes;
    }

    @Override
    public String toString() {
        return "RpcRequestConfig{" +
            "host='" + host + '\'' +
            ", port=" + port +
            ", service='" + service + '\'' +
            ", method='" + method + '\'' +
            ", tag='" + tag + '\'' +
            ", params=" + params +
            ", paramTypes=" + paramTypes +
            '}';
    }
}
