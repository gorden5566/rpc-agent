package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;
import com.gorden5566.rpc.agent.core.spi.InvokerBuilder;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class DefaultInvokerBuilder implements InvokerBuilder {
    @Override
    public Invoker buildInvoker(InvokerConfig config) throws Exception {
        return new DefaultInvoker(config);
    }
}
