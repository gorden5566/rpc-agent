package com.gorden5566.rpc.agent.core.internal;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class DefaultInvoker implements Invoker {
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
        return RpcResponse.newSuccess(request);
    }
}
