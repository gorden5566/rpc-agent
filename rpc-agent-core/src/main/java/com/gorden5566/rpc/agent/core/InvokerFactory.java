package com.gorden5566.rpc.agent.core;

import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class InvokerFactory {
    private static Invoker invoker = ExtensionLoader.loadFirst(Invoker.class);

    public static Invoker getInstance() {
        return invoker;
    }
}
