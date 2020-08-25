package com.gorden5566.rpc.agent.core.internal.config;

import com.alibaba.fastjson.JSONArray;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class DefaultRpcConfigParser extends AbstractRpcConfigParser {

    public DefaultRpcConfigParser() {
        // for check config
        this.addRpcConfigProcessor(new RpcConfigCheckProcessor());
    }

    @Override
    public RpcRequestConfig getConfigSample() {
        RpcRequestConfig config = new RpcRequestConfig();
        config.setPort(1234);
        config.setHost("127.0.0.1");
        config.setService("com.gorden5566.demo.service.HelloService");
        config.setMethod("sayHello");
        config.setTag("test");
        config.setParams(new JSONArray());
        return config;
    }
}
