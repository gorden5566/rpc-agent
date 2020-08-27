package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;
import com.gorden5566.rpc.agent.core.spi.InvokerBuilder;
import com.gorden5566.rpc.agent.core.spi.InvokerFactory;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class DefaultInvokerFactory implements InvokerFactory {
    private InvokerBuilder invokerBuilder = InstanceFactory.getInvokerBuilder();

    @Override
    public Invoker getInvoker(InvokerConfig config) throws Exception {
        // just build a invoker instance now
        return invokerBuilder.buildInvoker(config);
    }

    @Override
    public void preProcess(Invoker invoker) throws Exception {
        invoker.start();
    }

    @Override
    public void postProcess(Invoker invoker) throws Exception {
        if (invoker.isStarted() && !invoker.isStopped()) {
            invoker.stop();
        }
    }
}
