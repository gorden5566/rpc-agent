package com.gorden5566.rpc.agent.server;

import java.net.InetSocketAddress;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public abstract class AbstractAgentServer implements AgentServer {
    protected static final String INVOKER_PATH = "/agent";

    protected String host;
    protected int port;

    public AbstractAgentServer(String host, int port) {
        this.host = host;
        this.port = port;
        this.init();
    }

    private void init() {
        RpcAgentShutdownHook.getInstance().registerAgentServer(AbstractAgentServer.this).register();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    protected String formatAddress(String host, int port) {
        StringBuilder sb = new StringBuilder();
        sb.append(host).append(":").append(port).append(INVOKER_PATH);
        return sb.toString();
    }
}
