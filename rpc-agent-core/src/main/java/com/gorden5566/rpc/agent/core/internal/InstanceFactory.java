package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.*;

/**
 * @author gorden5566
 * @date 2020/08/20
 */
public class InstanceFactory {
    /**
     * this is the main entrance
     *
     * @return
     */
    public static InvokerProxy getInvokerProxy() {
        return InvokerProxyManager.getInvokerProxy();
    }

    /**
     * for get a Invoker
     *
     * @return
     */
    public static InvokerFactory getInvokerFactory() {
        return InvokerFactoryManager.getInvokerFactory();
    }

    /**
     * for build a Invoker
     *
     * @return
     */
    public static InvokerBuilder getInvokerBuilder() {
        return InvokerBuilderManager.getInstance();
    }

    /**
     * for parse a RpcRequestConfig
     *
     * @return
     */
    public static RpcConfigParser getRpcConfigParser() {
        return RpcConfigParserManager.getInstance();
    }

    /**
     * for format a RpcResponse
     *
     * @return
     */
    public static RpcFormatter getRpcFormatter() {
        return RpcFormatterManager.getInstance();
    }
}
