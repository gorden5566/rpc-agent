package com.gorden5566.rpc.agent.core.internal;

import java.util.UUID;

import com.alibaba.fastjson.JSONArray;
import com.gorden5566.rpc.agent.core.spi.RpcConfigParser;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class DefaultRpcConfigParser implements RpcConfigParser {
    @Override
    public RpcRequestConfig processRpcRequest(RpcRequestConfig config) {
        return config;
    }

    @Override
    public RpcRequest parseRpcRequest(RpcRequestConfig config) {
        JSONArray paramTypes = config.getParamTypes();
        RpcRequest request = RpcRequestBuilder.builder()
            .serviceName(config.getService())
            .methodName(config.getMethod())
            .tag(config.getTag())
            .params(config.getParams().toJSONString())
            .paramTypes(paramTypes == null ? null : paramTypes.toJSONString())
            .reqId(UUID.randomUUID().toString().replaceAll("-", ""))
            .rpcId("1")
            .build();
        return request;
    }
}
