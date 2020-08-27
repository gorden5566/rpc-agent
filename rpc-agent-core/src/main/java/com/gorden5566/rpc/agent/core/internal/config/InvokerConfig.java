package com.gorden5566.rpc.agent.core.internal.config;

import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

import java.util.Objects;

/**
 * @author gorden5566
 * @date 2020/08/25
 */
public class InvokerConfig {
    private String host;
    private Integer port;

    public InvokerConfig() {
    }

    public InvokerConfig(RpcRequestConfig config) {
        this.host = config.getHost();
        this.port = config.getPort();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InvokerConfig config = (InvokerConfig) o;
        return Objects.equals(host, config.host) &&
            Objects.equals(port, config.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }
}
