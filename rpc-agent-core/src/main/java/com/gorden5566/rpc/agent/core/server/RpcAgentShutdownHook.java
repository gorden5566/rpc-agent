package com.gorden5566.rpc.agent.core.server;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class RpcAgentShutdownHook extends Thread {
    private static final RpcAgentShutdownHook INSTANCE = new RpcAgentShutdownHook("RpcAgentShutdownHook");

    private final AtomicBoolean registered = new AtomicBoolean(false);
    private final AtomicBoolean destroyed = new AtomicBoolean(false);

    private AgentServer agentServer;

    private RpcAgentShutdownHook(String name) {
        super(name);
    }

    public static RpcAgentShutdownHook getInstance() {
        return INSTANCE;
    }

    public RpcAgentShutdownHook registerAgentServer(AgentServer agentServer) {
        this.agentServer = agentServer;
        return this;
    }

    @Override
    public void run() {
        doDestroy();
    }

    public void register() {
        if (!registered.get() && registered.compareAndSet(false, true)) {
            Runtime.getRuntime().addShutdownHook(getInstance());
        }
    }

    public void unregister() {
        if (registered.get() && registered.compareAndSet(true, false)) {
            Runtime.getRuntime().removeShutdownHook(getInstance());
        }
    }

    public void doDestroy() {
        if (!destroyed.compareAndSet(false, true)) {
            return;
        }
        // doDestroy
        if (agentServer != null) {
            try {
                agentServer.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
