package com.gorden5566.rpc.agent.simple;

import com.gorden5566.rpc.agent.core.internal.DefaultInvokerBuilder;
import com.gorden5566.rpc.agent.core.internal.Invoker;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;

/**
 * @author gorden5566
 * @date 2020/08/23
 */
public class SimpleInvokerBuilder extends DefaultInvokerBuilder {
    @Override
    public Invoker buildInvoker(RpcRequestConfig config) {
        return new SimpleInvoker(config);
    }
}
