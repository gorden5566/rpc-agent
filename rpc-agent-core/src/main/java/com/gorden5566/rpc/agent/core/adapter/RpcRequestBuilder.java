package com.gorden5566.rpc.agent.core.adapter;

import com.gorden5566.rpc.agent.core.model.RpcRequest;
import com.gorden5566.rpc.agent.core.model.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public interface RpcRequestBuilder {

    /**
     * buildRpcRequest
     *
     * @param config
     * @return
     */
    RpcRequest buildRpcRequest(RpcRequestConfig config);
}
