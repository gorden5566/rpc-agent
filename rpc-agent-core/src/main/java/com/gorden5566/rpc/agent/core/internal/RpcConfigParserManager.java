package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.RpcConfigParser;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class RpcConfigParserManager {
    private static volatile RpcConfigParser instance;
    private static Object lock = new Object();

    public static RpcConfigParser getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }

    private static RpcConfigParser newInstance() {
        return ExtensionLoader.loadFirst(RpcConfigParser.class, () -> new DefaultRpcConfigParser());
    }

}
