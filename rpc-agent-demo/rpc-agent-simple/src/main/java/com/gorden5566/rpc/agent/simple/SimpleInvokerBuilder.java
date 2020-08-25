package com.gorden5566.rpc.agent.simple;

import com.gorden5566.rpc.agent.core.internal.Invoker;
import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;
import com.gorden5566.rpc.agent.core.spi.InvokerBuilder;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class SimpleInvokerBuilder implements InvokerBuilder {
    @Override
    public Invoker buildInvoker(InvokerConfig config) {
        return new SimpleInvoker(config);
    }
}
