package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.DefaultInvokerProxy;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class InvokerProxyFactory {
    private static InvokerProxy invokerProxy =
        ExtensionLoader.loadFirst(InvokerProxy.class, () -> new DefaultInvokerProxy());

    public static InvokerProxy getInstance() {
        return invokerProxy;
    }
}
