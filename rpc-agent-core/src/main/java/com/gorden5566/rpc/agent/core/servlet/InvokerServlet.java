package com.gorden5566.rpc.agent.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gorden5566.rpc.agent.core.InvokerProxyFactory;
import com.gorden5566.rpc.agent.core.builder.RpcRequestConfigBuilder;
import com.gorden5566.rpc.agent.core.model.ResponseError;
import com.gorden5566.rpc.agent.core.model.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.util.HttpUtils;
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
            RpcRequestConfig config = RpcRequestConfigBuilder.newBuilder().request(request).build();

            String result = InvokerProxyFactory.getInstance().invoke(config);

            HttpUtils.writeJson(response, result);
        } catch (Exception e) {
            ResponseError error = ResponseError.newThrowableError("remote call failed", e, 400);
            HttpUtils.writeJson(response, JsonUtils.toPrettyJson(error));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        doGet(request, response);
    }
}
