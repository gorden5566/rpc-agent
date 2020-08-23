package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.InvokerProxy;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class InvokerProxyManager {
    private static volatile InvokerProxy instance;
    private static Object lock = new Object();

    public static InvokerProxy getInvokerProxy() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }

    private static InvokerProxy newInstance() {
        return ExtensionLoader.loadFirst(InvokerProxy.class, () -> new DefaultInvokerProxy());
    }
}
