package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.RpcRequest;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public interface RpcConfigParser {

    /**
     * parseRpcRequest
     *
     * @param config
     * @return
     */
    RpcRequest parseRpcRequest(RpcRequestConfig config);
}
