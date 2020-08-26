package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;

/**
 * @author gorden5566
 * @date 2020/08/27
 */
public abstract class AbstractInvoker implements Invoker {
    private InvokerConfig config;

    public AbstractInvoker() {
    }

    public AbstractInvoker(InvokerConfig config) {
        this.config = config;
    }

    @Override
    public InvokerConfig getConfig() {
        return config;
    }
}
