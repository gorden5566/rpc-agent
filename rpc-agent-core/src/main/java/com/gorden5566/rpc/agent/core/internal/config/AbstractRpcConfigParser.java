package com.gorden5566.rpc.agent.core.internal.config;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import com.alibaba.fastjson.JSONArray;
import com.gorden5566.rpc.agent.core.internal.RpcRequest;
import com.gorden5566.rpc.agent.core.internal.RpcRequestBuilder;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.RpcResponse;
import com.gorden5566.rpc.agent.core.spi.RpcConfigParser;

/**
 * @author gorden5566
 * @date 2020/08/26
 */
public abstract class AbstractRpcConfigParser implements RpcConfigParser {

    private List<RpcConfigProcessor> processors = new CopyOnWriteArrayList<>();

    @Override
    public void addRpcConfigProcessor(RpcConfigProcessor processor) {
        if (!processors.contains(processor)) {
            processors.add(processor);
        }
    }

    @Override
    public RpcResponse processConfig(RpcRequestConfig config) {
        if (processors == null || processors.isEmpty()) {
            return null;
        }

        for (RpcConfigProcessor processor : processors) {
            RpcResponse response = processor.processConfig(config);
            if (response != null) {
                return response;
            }
        }
        return null;
    }

    @Override
    public ParsedRequestConfig parseConfig(RpcRequestConfig config) {
        ParsedRequestConfig parsedConfig = new ParsedRequestConfig();
        parsedConfig.setRpcRequest(buildRpcRequest(config));
        parsedConfig.setInvokerConfig(buildInvokerConfig(config));

        return parsedConfig;
    }

    /**
     * build rpc request
     *
     * @param config
     * @return
     */
    protected RpcRequest buildRpcRequest(RpcRequestConfig config) {
        JSONArray paramTypes = config.getParamTypes();
        return RpcRequestBuilder.builder()
            .serviceName(config.getService())
            .methodName(config.getMethod())
            .tag(config.getTag())
            .params(config.getParams().toJSONString())
            .paramTypes(paramTypes == null ? null : paramTypes.toJSONString())
            .reqId(UUID.randomUUID().toString().replaceAll("-", ""))
            .rpcId("1")
            .build();
    }

    /**
     * build invoker config
     *
     * @param config
     * @return
     */
    protected InvokerConfig buildInvokerConfig(RpcRequestConfig config) {
        return new InvokerConfig(config);
    }
}
