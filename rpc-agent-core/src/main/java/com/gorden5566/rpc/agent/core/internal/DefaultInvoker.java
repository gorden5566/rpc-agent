package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class DefaultInvoker extends AbstractInvoker {
    public DefaultInvoker() {
    }

    public DefaultInvoker(InvokerConfig config) {
        super(config);
    }

    @Override
    public void doStart() throws Exception {
        // ignore
    }

    @Override
    public void doStop() throws Exception {
        // ignore
    }

    @Override
    public RpcResponse invoke(RpcRequest request) {
        return RpcResponse.newSuccess(request);
    }
}
