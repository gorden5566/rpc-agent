package com.gorden5566.rpc.agent.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gorden5566.rpc.agent.core.internal.InstanceFactory;
import com.gorden5566.rpc.agent.server.builder.RpcRequestConfigBuilder;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.RpcResponse;
import com.gorden5566.rpc.agent.core.spi.InvokerProxy;
import com.gorden5566.rpc.agent.server.util.HttpUtils;
import com.gorden5566.rpc.agent.core.util.JsonUtils;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class InvokerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            // parse request
            RpcRequestConfig config = buildRpcRequestConfig(request);

            String result = getInvokerProxy().invoke(config);

            HttpUtils.writeJson(response, result);
        } catch (Exception e) {
            RpcResponse error = RpcResponse.newThrowableError("remote call failed", e);
            HttpUtils.writeJson(response, JsonUtils.toPrettyJson(error));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        doGet(request, response);
    }

    private RpcRequestConfig buildRpcRequestConfig(HttpServletRequest request) throws IOException {
        return RpcRequestConfigBuilder.newBuilder().request(request).build();
    }

    private InvokerProxy getInvokerProxy() {
        return InstanceFactory.getInvokerProxy();
    }
}
