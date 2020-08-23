package com.gorden5566.rpc.agent.simple;

import com.gorden5566.rpc.agent.core.internal.DefaultRpcConfigParser;
import com.gorden5566.rpc.agent.core.internal.RpcRequest;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class SimpleRpcConfigParser extends DefaultRpcConfigParser {
    @Override
    public RpcRequestConfig processRpcRequest(RpcRequestConfig config) {
        return super.processRpcRequest(config);
    }

    @Override
    public RpcRequest parseRpcRequest(RpcRequestConfig config) {
        return super.parseRpcRequest(config);
    }
}
