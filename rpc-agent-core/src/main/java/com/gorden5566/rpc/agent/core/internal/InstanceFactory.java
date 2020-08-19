package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.InvokerBuilder;
import com.gorden5566.rpc.agent.core.spi.InvokerProxy;
import com.gorden5566.rpc.agent.core.spi.RpcFormatter;
import com.gorden5566.rpc.agent.core.spi.RpcRequestBuilder;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/20
 */
public class InstanceFactory {
    private static InvokerProxy invokerProxy;
    private static InvokerBuilder invokerBuilder;
    private static RpcRequestBuilder rpcRequestBuilder;
    private static RpcFormatter rpcFormatter;

    static {
        invokerProxy = ExtensionLoader.loadFirst(InvokerProxy.class, () -> new DefaultInvokerProxy());
        invokerBuilder = ExtensionLoader.loadFirst(InvokerBuilder.class, () -> new DefaultInvokerBuilder());
        rpcRequestBuilder = ExtensionLoader.loadFirst(RpcRequestBuilder.class, () -> new DefaultRpcRequestBuilder());
        rpcFormatter = ExtensionLoader.loadFirst(RpcFormatter.class, () -> new DefaultRpcFormatter());
    }

    public static InvokerProxy getInvokerProxy() {
        return invokerProxy;
    }

    public static InvokerBuilder getInvokerBuilder() {
        return invokerBuilder;
    }

    public static RpcRequestBuilder getRpcRequestBuilder() {
        return rpcRequestBuilder;
    }

    public static RpcFormatter getRpcFormatter() {
        return rpcFormatter;
    }
}
