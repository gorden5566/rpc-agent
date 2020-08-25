package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.config.ParsedRequestConfig;
import com.gorden5566.rpc.agent.core.internal.config.RpcConfigProcessor;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.RpcResponse;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public interface RpcConfigParser {

    /**
     * get a config sample. used for display.
     *
     * @return
     */
    RpcRequestConfig getConfigSample();

    /**
     * add a RpcConfigProcessor
     *
     * @param processor
     */
    void addRpcConfigProcessor(RpcConfigProcessor processor);

    /**
     * process config. return a RpcResponse when failed.
     *
     * @param config
     * @return
     */
    RpcResponse processConfig(RpcRequestConfig config);

    /**
     * parse config, you can get all required result.
     *
     * @param config
     * @return
     */
    ParsedRequestConfig parseConfig(RpcRequestConfig config);
}
