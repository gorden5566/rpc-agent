package com.gorden5566.rpc.agent.core.adapter;

import com.gorden5566.rpc.agent.core.model.RpcRequest;
import com.gorden5566.rpc.agent.core.model.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class DefaultRpcRequestBuilder implements RpcRequestBuilder {
    @Override
    public RpcRequest buildRpcRequest(RpcRequestConfig config) {
        return new DefaultRpcRequestAdapter(config);
    }
}
