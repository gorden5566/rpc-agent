package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.InvokerFactory;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class InvokerFactoryManager {
    private static volatile InvokerFactory instance;
    private static Object lock = new Object();

    public static InvokerFactory getInvokerFactory() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }

    private static InvokerFactory newInstance() {
        return ExtensionLoader.loadFirst(InvokerFactory.class, () -> new DefaultInvokerFactory());
    }
}
