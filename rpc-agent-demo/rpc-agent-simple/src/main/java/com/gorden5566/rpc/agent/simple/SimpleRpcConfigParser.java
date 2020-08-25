package com.gorden5566.rpc.agent.simple;

import com.alibaba.fastjson.JSONArray;
import com.gorden5566.rpc.agent.core.internal.RpcRequest;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.config.AbstractRpcConfigParser;
import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;
import com.gorden5566.rpc.agent.core.internal.config.RpcConfigCheckProcessor;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class SimpleRpcConfigParser extends AbstractRpcConfigParser {

    public SimpleRpcConfigParser() {
        this.addRpcConfigProcessor(new RpcConfigCheckProcessor());
    }

    @Override
    public RpcRequestConfig getConfigSample() {
        RpcRequestConfig config = new RpcRequestConfig();
        config.setPort(1234);
        config.setHost("127.0.0.1");
        config.setService("com.gorden5566.demo.service.SimpleService");
        config.setMethod("simple");
        config.setTag("");
        config.setParams(new JSONArray());
        return config;
    }

    @Override
    protected RpcRequest buildRpcRequest(RpcRequestConfig config) {
        return super.buildRpcRequest(config);
    }

    @Override
    protected InvokerConfig buildInvokerConfig(RpcRequestConfig config) {
        return super.buildInvokerConfig(config);
    }
}
