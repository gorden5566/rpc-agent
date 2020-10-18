package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;

/**
 * A Invoker is used for send a rpc request to a remote server,
 * and then format response to RpcResponse. In order to define
 * concrete Invoker for a RPC framework, such as Dubbo and so on,
 * you can implement this interface or extend AbstractInvoker class.
 *
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
