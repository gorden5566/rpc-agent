package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public interface InvokerProxy {

    /**
     * invoke
     *
     * @param config
     * @return
     * @throws Exception
     */
    String invoke(RpcRequestConfig config) throws Exception;
}
