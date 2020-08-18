package com.gorden5566.rpc.agent.core.internal;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public interface Invoker {

    /**
     * start
     *
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * stop
     *
     * @throws Exception
     */
    void stop() throws Exception;

    /**
     * invoke
     *
     * @param request
     * @return
     */
    RpcResponse invoke(RpcRequest request);
}
