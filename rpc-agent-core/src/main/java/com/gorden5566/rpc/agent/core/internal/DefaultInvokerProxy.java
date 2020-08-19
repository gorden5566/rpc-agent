package com.gorden5566.rpc.agent.core.internal;

import org.apache.commons.lang.StringUtils;

import com.gorden5566.rpc.agent.core.context.RpcContext;
import com.gorden5566.rpc.agent.core.spi.InvokerProxy;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class DefaultInvokerProxy implements InvokerProxy {
    @Override
    public String invoke(RpcRequestConfig config) throws Exception {
        try {
            RpcContext.getContext().setTag(config.getTag());

            return doInvoke(config);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RpcContext.removeContext();
        }
        return null;
    }

    private String doInvoke(RpcRequestConfig config) throws Exception {
        // check config
        RpcResponse responseError = preCheck(config);
        if (responseError != null) {
            return formatResponse(responseError);
        }

        // build request
        RpcRequest request = buildRpcRequest(config);

        // get invoker
        Invoker invoker = getInvoker(config);
        invoker.start();

        // do invoke
        RpcResponse response = invoker.invoke(request);

        invoker.stop();

        return formatResponse(response);
    }

    private Invoker getInvoker(RpcRequestConfig config) {
        // just build a new Invoker instance
        return InstanceFactory.getInvokerBuilder().build(config);
    }

    private RpcRequest buildRpcRequest(RpcRequestConfig config) {
        return InstanceFactory.getRpcConfigParser().parseRpcRequest(config);
    }

    private String formatResponse(RpcResponse response) {
        return InstanceFactory.getRpcFormatter().formatResponse(response);
    }

    private RpcResponse preCheck(RpcRequestConfig config) {
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
}
