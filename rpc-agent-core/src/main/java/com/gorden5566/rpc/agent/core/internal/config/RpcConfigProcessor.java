package com.gorden5566.rpc.agent.core.internal.config;

import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.RpcResponse;

/**
 * @author gorden5566
 * @date 2020/08/26
 */
public interface RpcConfigProcessor {
    /**
     * process config
     *
     * @param config
     * @return
     */
    RpcResponse processConfig(RpcRequestConfig config);
}
