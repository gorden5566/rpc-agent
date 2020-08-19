package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.RpcConfigParser;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class DefaultRpcConfigParser implements RpcConfigParser {
    @Override
    public RpcRequest parseRpcRequest(RpcRequestConfig config) {
        return new DefaultRpcRequestAdapter(config);
    }
}
