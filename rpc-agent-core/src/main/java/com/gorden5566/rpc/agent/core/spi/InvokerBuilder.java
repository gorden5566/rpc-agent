package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.Invoker;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public interface InvokerBuilder {

    /**
     * build a invoker
     *
     * @param config
     * @return
     */
    Invoker buildInvoker(RpcRequestConfig config);
}
