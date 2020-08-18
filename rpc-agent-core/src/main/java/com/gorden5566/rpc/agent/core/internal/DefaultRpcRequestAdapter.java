package com.gorden5566.rpc.agent.core.internal;

import java.util.UUID;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class DefaultRpcRequestAdapter implements RpcRequest {

    private RpcRequestConfig config;

    public DefaultRpcRequestAdapter(RpcRequestConfig config) {
        this.config = config;
    }

    @Override
    public String getServiceName() {
        return config.getService();
    }

    @Override
    public String getMethodName() {
        return config.getMethod();
    }

    @Override
    public String getRequestJson() {
        return config.getParams().toJSONString();
    }

    @Override
    public String getReqId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    public String getRpcId() {
        return "1";
    }

    @Override
    public String getTag() {
        return config.getTag();
    }
}
