package com.gorden5566.rpc.agent.core.builder;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.util.HttpUtils;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class RpcRequestConfigBuilder {
    private HttpServletRequest request;

    public static RpcRequestConfigBuilder newBuilder() {
        return new RpcRequestConfigBuilder();
    }

    public RpcRequestConfigBuilder request(HttpServletRequest request) {
        this.request = request;
        return this;
    }

    public RpcRequestConfig build() throws IOException {
        String bodyString = HttpUtils.getBodyString(request);
        return JSON.parseObject(bodyString, RpcRequestConfig.class);
    }
}
