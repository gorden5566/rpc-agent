package com.gorden5566.rpc.agent.core.internal.config;

import com.gorden5566.rpc.agent.core.internal.RpcRequest;

/**
 * @author gorden5566
 * @date 2020/08/25
 */
public class ParsedRequestConfig {

    private InvokerConfig invokerConfig;

    private RpcRequest rpcRequest;

    public InvokerConfig getInvokerConfig() {
        return invokerConfig;
    }

    public void setInvokerConfig(InvokerConfig invokerConfig) {
        this.invokerConfig = invokerConfig;
    }

    public RpcRequest getRpcRequest() {
        return rpcRequest;
    }

    public void setRpcRequest(RpcRequest rpcRequest) {
        this.rpcRequest = rpcRequest;
    }
}
