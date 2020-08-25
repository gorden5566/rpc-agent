package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;
import com.gorden5566.rpc.agent.core.internal.Invoker;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public interface InvokerFactory {

    /**
     * get a Invoker
     *
     * @param config
     * @return
     */
    Invoker getInvoker(InvokerConfig config);
}
