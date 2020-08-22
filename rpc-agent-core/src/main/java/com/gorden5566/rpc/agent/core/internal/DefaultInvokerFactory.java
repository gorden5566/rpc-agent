package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.InvokerFactory;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class DefaultInvokerFactory implements InvokerFactory {
    @Override
    public Invoker getInvoker(RpcRequestConfig config) {
        return new DefaultInvoker();
    }
}
