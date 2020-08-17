package com.gorden5566.rpc.agent.core.adapter;

import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class RpcRequestBuilderFactory {
    private static RpcRequestBuilder builder;
    static {
        builder = ExtensionLoader.loadFirst(RpcRequestBuilder.class);
        if (builder == null) {
            builder = new DefaultRpcRequestBuilder();
        }
    }

    public static RpcRequestBuilder getInstance() {
        return builder;
    }
}
