package com.gorden5566.rpc.agent.simple;

import com.gorden5566.rpc.agent.core.internal.Invoker;
import com.gorden5566.rpc.agent.core.internal.RpcRequest;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.RpcResponse;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class SimpleInvoker implements Invoker {

    private RpcRequestConfig config;

    public SimpleInvoker() {
    }

    public SimpleInvoker(RpcRequestConfig config) {
        this.config = config;
    }

    @Override
    public void start() throws Exception {
        // ignore
    }

    @Override
    public void stop() throws Exception {
        // ignore
    }

    @Override
    public RpcResponse invoke(RpcRequest request) {
        return RpcResponse.newSuccess(config);
    }
}