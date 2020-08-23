package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.RpcFormatter;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class RpcFormatterManager {
    private static volatile RpcFormatter instance;
    private static Object lock = new Object();

    public static RpcFormatter getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }

    private static RpcFormatter newInstance() {
        return ExtensionLoader.loadFirst(RpcFormatter.class, () -> new DefaultRpcFormatter());
    }
}
