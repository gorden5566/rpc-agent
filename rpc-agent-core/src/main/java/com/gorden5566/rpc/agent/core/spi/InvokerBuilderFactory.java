package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.DefaultInvokerBuilder;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class InvokerBuilderFactory {
    private static InvokerBuilder builder =
        ExtensionLoader.loadFirst(InvokerBuilder.class, () -> new DefaultInvokerBuilder());

    public static InvokerBuilder getInstance() {
        return builder;
    }
}
