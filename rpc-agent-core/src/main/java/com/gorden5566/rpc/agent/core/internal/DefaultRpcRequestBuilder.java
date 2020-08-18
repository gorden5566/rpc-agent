package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.RpcRequestBuilder;

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
