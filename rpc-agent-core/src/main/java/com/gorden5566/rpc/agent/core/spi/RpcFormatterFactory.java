package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.DefaultRpcFormatter;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/20
 */
public class RpcFormatterFactory {
    private static RpcFormatter formatter = ExtensionLoader.loadFirst(RpcFormatter.class, () -> new DefaultRpcFormatter());

    public static RpcFormatter getInstance() {
        return formatter;
    }
}
