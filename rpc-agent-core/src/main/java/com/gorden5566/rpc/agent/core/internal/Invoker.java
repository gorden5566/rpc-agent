package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public interface Invoker extends LifeCycle {
    /**
     * invoke
     *
     * @param request
     * @return
     */
    RpcResponse invoke(RpcRequest request);

    /**
     * get invoker config
     *
     * @return
     */
    InvokerConfig getConfig();
}
