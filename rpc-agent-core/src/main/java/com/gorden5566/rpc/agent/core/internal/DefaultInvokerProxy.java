package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;
import com.gorden5566.rpc.agent.core.internal.config.ParsedRequestConfig;
import com.gorden5566.rpc.agent.core.context.RpcContext;
import com.gorden5566.rpc.agent.core.spi.InvokerFactory;
import com.gorden5566.rpc.agent.core.spi.InvokerProxy;
import com.gorden5566.rpc.agent.core.spi.RpcConfigParser;
import com.gorden5566.rpc.agent.core.spi.RpcFormatter;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class DefaultInvokerProxy implements InvokerProxy {
    private RpcConfigParser rpcConfigParser = InstanceFactory.getRpcConfigParser();
    private InvokerFactory invokerFactory = InstanceFactory.getInvokerFactory();
    private RpcFormatter rpcFormatter = InstanceFactory.getRpcFormatter();

    @Override
    public String invoke(RpcRequestConfig config) throws Exception {
        RpcResponse response = null;

        try {
            RpcContext.getContext().setTag(config.getTag());
            response = doInvoke(config);
        } finally {
            RpcContext.removeContext();
        }

        return formatResponse(response);
    }

    private RpcResponse doInvoke(RpcRequestConfig config) throws Exception {
        // process config
        RpcResponse responseError = processConfig(config);
        if (responseError != null) {
            return responseError;
        }

        // parse config
        ParsedRequestConfig parsedConfig = parseConfig(config);

        // get invoker
        Invoker invoker = getInvoker(parsedConfig.getInvokerConfig());

        // do invoke
        invoker.start();
        RpcResponse response = invoker.invoke(parsedConfig.getRpcRequest());
        invoker.stop();

        return response;
    }

    private Invoker getInvoker(InvokerConfig config) {
        return invokerFactory.getInvoker(config);
    }

    private ParsedRequestConfig parseConfig(RpcRequestConfig config) {
        return rpcConfigParser.parseConfig(config);
    }

    private String formatResponse(RpcResponse response) {
        return rpcFormatter.formatResponse(response);
    }

    private RpcResponse processConfig(RpcRequestConfig config) {
        return rpcConfigParser.processConfig(config);
    }
}
