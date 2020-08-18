package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.InvokerBuilder;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class DefaultInvokerBuilder implements InvokerBuilder {
    @Override
    public Invoker build(RpcRequestConfig config) {
        return new DefaultInvoker();
    }
}
