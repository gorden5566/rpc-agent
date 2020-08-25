package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.RpcRequest;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public interface RpcConfigParser {

    /**
     * build a sample config
     *
     * @return
     */
    RpcRequestConfig buildDefaultConfig();

    /**
     * processRpcRequest
     *
     * @param config
     * @return
     */
    RpcRequestConfig processRpcRequest(RpcRequestConfig config);

    /**
     * parseRpcRequest
     *
     * @param config
     * @return
     */
    RpcRequest parseRpcRequest(RpcRequestConfig config);
}
