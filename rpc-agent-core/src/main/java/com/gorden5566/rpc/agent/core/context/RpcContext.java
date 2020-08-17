package com.gorden5566.rpc.agent.core.context;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class RpcContext {
    private static final ThreadLocal<RpcContext> LOCAL = ThreadLocal.withInitial(() -> new RpcContext());

    private String tag;

    public static RpcContext getContext() {
        return LOCAL.get();
    }

    public static void removeContext() {
        LOCAL.remove();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
