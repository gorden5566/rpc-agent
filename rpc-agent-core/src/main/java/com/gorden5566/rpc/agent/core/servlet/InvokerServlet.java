package com.gorden5566.rpc.agent.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.gorden5566.rpc.agent.core.InvokerProxyFactory;
import com.gorden5566.rpc.agent.core.model.ResponseError;
import com.gorden5566.rpc.agent.core.model.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.util.HttpUtils;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class InvokerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String bodyString = HttpUtils.getBodyString(request);
        RpcRequestConfig config = JSON.parseObject(bodyString, RpcRequestConfig.class);

        try {
            String result = InvokerProxyFactory.getInstance().invoke(config);

            HttpUtils.writeJson(response, result);
        } catch (Exception e) {
            ResponseError error = ResponseError.newInstance("remote call failed", e, 400);
            HttpUtils.writeJson(response, JSON.toJSONString(error, true));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        doGet(request, response);
    }
}
