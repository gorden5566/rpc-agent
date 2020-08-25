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
    public RpcRequestConfig buildDefaultConfig() {
        RpcRequestConfig config = new RpcRequestConfig();
        config.setPort(1234);
        config.setHost("127.0.0.1");
        config.setService("com.gorden5566.demo.service.HelloService");
        config.setMethod("sayHello");
        config.setTag("test");
        config.setParams(new JSONArray());
        return config;
    }

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
