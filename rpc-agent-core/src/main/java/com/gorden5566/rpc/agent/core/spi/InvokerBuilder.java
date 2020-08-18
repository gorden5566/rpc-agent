package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.Invoker;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public interface InvokerBuilder {

    /**
     * build invoker
     *
     * @param config
     * @return
     */
    Invoker build(RpcRequestConfig config);
}
