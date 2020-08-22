package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.InvokerFactory;
import com.gorden5566.rpc.agent.core.spi.InvokerProxy;
import com.gorden5566.rpc.agent.core.spi.RpcFormatter;
import com.gorden5566.rpc.agent.core.spi.RpcConfigParser;
import com.gorden5566.rpc.agent.core.util.ExtensionLoader;

/**
 * @author gorden5566
 * @date 2020/08/20
 */
public class InstanceFactory {
    private static InvokerProxy invokerProxy;
    private static InvokerFactory invokerFactory;
    private static RpcConfigParser rpcConfigParser;
    private static RpcFormatter rpcFormatter;

    static {
        invokerProxy = ExtensionLoader.loadFirst(InvokerProxy.class, () -> new DefaultInvokerProxy());
        invokerFactory = ExtensionLoader.loadFirst(InvokerFactory.class, () -> new DefaultInvokerFactory());
        rpcConfigParser = ExtensionLoader.loadFirst(RpcConfigParser.class, () -> new DefaultRpcConfigParser());
        rpcFormatter = ExtensionLoader.loadFirst(RpcFormatter.class, () -> new DefaultRpcFormatter());
    }

    /**
     * this is the main entrance
     *
     * @return
     */
    public static InvokerProxy getInvokerProxy() {
        return invokerProxy;
    }

    /**
     * for getInvoker a Invoker
     *
     * @return
     */
    public static InvokerFactory getInvokerFactory() {
        return invokerFactory;
    }

    /**
     * for parse a RpcRequestConfig
     *
     * @return
     */
    public static RpcConfigParser getRpcConfigParser() {
        return rpcConfigParser;
    }

    /**
     * for formatter a RpcResponse
     *
     * @return
     */
    public static RpcFormatter getRpcFormatter() {
        return rpcFormatter;
    }
}
