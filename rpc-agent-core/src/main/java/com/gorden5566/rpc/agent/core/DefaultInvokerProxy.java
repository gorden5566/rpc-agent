package com.gorden5566.rpc.agent.core;

import com.gorden5566.rpc.agent.core.context.RpcContext;
import com.gorden5566.rpc.agent.core.model.ResponseError;
import com.gorden5566.rpc.agent.core.model.RpcRequest;
import com.gorden5566.rpc.agent.core.model.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.model.RpcResponse;
import com.gorden5566.rpc.agent.core.util.JsonUtils;
import org.apache.commons.lang.StringUtils;

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
        ResponseError responseError = preCheck(config);
        if (responseError != null) {
            String errorInfo = JsonUtils.toPrettyJson(responseError);
            System.out.println(errorInfo);
            return errorInfo;
        }

        Invoker invoker = InvokerFactory.getInstance();
        invoker.start(config);

        // convert to request
        RpcRequest request = null;

        RpcResponse response = InvokerFactory.getInstance().invoke(request);

        invoker.stop();

        return JsonUtils.toPrettyJson(response);
    }

    private ResponseError preCheck(RpcRequestConfig config) {
        if (config == null) {
            return ResponseError.newError("config cannot be null", null, 400);
        }

        if (StringUtils.isBlank(config.getHost())) {
            return ResponseError.newError("[host] cannot be empty", null, 400);
        }

        if (config.getPort() == null) {
            return ResponseError.newError("[port] cannot be empty", null, 400);
        }

        if (StringUtils.isBlank(config.getService())) {
            return ResponseError.newError("[service] cannot be empty", null, 400);
        }

        if (StringUtils.isBlank(config.getMethod())) {
            return ResponseError.newError("[method] cannot be empty", null, 400);
        }

        return null;
    }
}
