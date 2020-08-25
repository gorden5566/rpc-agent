package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.RpcResponse;

/**
 * @author gorden5566
 * @date 2020/08/20
 */
public interface RpcFormatter {

    /**
     * format response
     *
     * @param response
     * @return
     */
    String formatResponse(RpcResponse response);
}
