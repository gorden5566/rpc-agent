package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;
import com.gorden5566.rpc.agent.core.internal.Invoker;

/**
 * A InvokerBuilder is used for build a Invoker.
 *
 * @author gorden5566
 * @date 2020/08/23
 */
public interface InvokerBuilder {

    /**
     * build a invoker
     *
     * @param config
     * @return
     * @throws Exception
     */
    Invoker buildInvoker(InvokerConfig config) throws Exception;
}
