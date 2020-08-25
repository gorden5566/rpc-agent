package com.gorden5566.rpc.agent.core.internal.config;

import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/25
 */
public class InvokerConfig {
    private String host;
    private Integer port;
    private Integer timeout;

    public InvokerConfig() {
    }

    public InvokerConfig(RpcRequestConfig config) {
        this.host = config.getHost();
        this.port = config.getPort();
        this.timeout = config.getTimeout();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
