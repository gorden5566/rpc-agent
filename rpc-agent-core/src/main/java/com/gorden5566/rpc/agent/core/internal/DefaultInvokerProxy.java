package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.InvokerFactory;
import com.gorden5566.rpc.agent.core.spi.RpcConfigParser;
import com.gorden5566.rpc.agent.core.spi.RpcFormatter;
import org.apache.commons.lang.StringUtils;

import com.gorden5566.rpc.agent.core.context.RpcContext;
import com.gorden5566.rpc.agent.core.spi.InvokerProxy;

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
        RpcRequestConfig processedConfig = processRpcRequest(config);

        // check config
        RpcResponse responseError = checkConfig(processedConfig);
        if (responseError != null) {
            return responseError;
        }

        // build rpc request
        RpcRequest request = buildRpcRequest(processedConfig);

        // get invoker
        Invoker invoker = getInvoker(processedConfig);
        invoker.start();

        // do invoke
        RpcResponse response = invoker.invoke(request);

        invoker.stop();

        return response;
    }

    private Invoker getInvoker(RpcRequestConfig config) {
        // get a Invoker instance
        return invokerFactory.getInvoker(config);
    }

    private RpcRequest buildRpcRequest(RpcRequestConfig config) {
        return rpcConfigParser.parseRpcRequest(config);
    }

    private String formatResponse(RpcResponse response) {
        return rpcFormatter.formatResponse(response);
    }

    private RpcResponse checkConfig(RpcRequestConfig config) {
        if (config == null) {
            return RpcResponse.newError("invalid parameters", "config cannot be null");
        }

        if (StringUtils.isBlank(config.getHost())) {
            return RpcResponse.newError("invalid parameters", "[host] cannot be empty");
        }

        if (config.getPort() == null) {
            return RpcResponse.newError("invalid parameters", "[port] cannot be empty");
        }

        if (StringUtils.isBlank(config.getService())) {
            return RpcResponse.newError("invalid parameters", "[service] cannot be empty");
        }

        if (StringUtils.isBlank(config.getMethod())) {
            return RpcResponse.newError("invalid parameters", "[method] cannot be empty");
        }

        if (config.getParams() == null) {
            return RpcResponse.newError("invalid parameters", "[params] cannot be null");
        }

        return null;
    }

    private RpcRequestConfig processRpcRequest(RpcRequestConfig config) {
        return rpcConfigParser.processRpcRequest(config);
    }
}
