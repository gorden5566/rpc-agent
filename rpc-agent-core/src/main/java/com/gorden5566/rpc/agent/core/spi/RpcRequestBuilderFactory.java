package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.DefaultRpcRequestBuilder;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class RpcRequestBuilderFactory {
    private static RpcRequestBuilder builder =
        ExtensionLoader.loadFirst(RpcRequestBuilder.class, () -> new DefaultRpcRequestBuilder());

    public static RpcRequestBuilder getInstance() {
        return builder;
    }
}
