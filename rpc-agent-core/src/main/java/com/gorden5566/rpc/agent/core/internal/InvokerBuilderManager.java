package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.InvokerBuilder;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class InvokerBuilderManager {
    private static volatile InvokerBuilder instance;
    private static Object lock = new Object();

    public static InvokerBuilder getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }

    private static InvokerBuilder newInstance() {
        return ExtensionLoader.loadFirst(InvokerBuilder.class, () -> new DefaultInvokerBuilder());
    }

}
