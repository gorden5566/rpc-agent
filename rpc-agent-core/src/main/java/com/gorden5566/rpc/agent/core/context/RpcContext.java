package com.gorden5566.rpc.agent.core.context;

import com.gorden5566.rpc.agent.core.internal.RpcRequest;
import com.gorden5566.rpc.agent.core.internal.config.ParsedRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class RpcContext {
    private static final ThreadLocal<RpcContext> LOCAL = ThreadLocal.withInitial(() -> new RpcContext());

    private String tag;

    private ParsedRequestConfig config;

    /**
     * get rpc context
     *
     * @return
     */
    public static RpcContext getContext() {
        return LOCAL.get();
    }

    /**
     * remove context after a rpc call
     */
    public static void removeContext() {
        LOCAL.remove();
    }

    /**
     * get tag
     *
     * @return
     */
    public String getTag() {
        return tag;
    }

    /**
     * set tag
     *
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * get parsed rpc request config
     *
     * @return
     */
    public ParsedRequestConfig getConfig() {
        return config;
    }

    /**
     * set parsed rpc request config
     *
     * @param config
     */
    public void setConfig(ParsedRequestConfig config) {
        this.config = config;
    }

    /**
     * get request id
     *
     * @return
     */
    public String getReqId() {
        if (config == null) {
            return null;
        }
        RpcRequest rpcRequest = config.getRpcRequest();
        return rpcRequest == null ? null : rpcRequest.getReqId();
    }
}
