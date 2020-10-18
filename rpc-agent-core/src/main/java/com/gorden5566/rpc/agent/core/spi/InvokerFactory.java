package com.gorden5566.rpc.agent.core.spi;

import com.gorden5566.rpc.agent.core.internal.config.InvokerConfig;
import com.gorden5566.rpc.agent.core.internal.Invoker;

/**
 * A InvokerFactory is used for get a concrete Invoker, the default
 * implementation is DefaultInvokerFactory. If more feature are required,
 * such as Invoker cache pool, please implement the InvokerFactory interface,
 * finally, remember register it by spi config.
 *
 * @author gorden5566
 * @date 2020/08/19
 */
public interface InvokerFactory {

    /**
     * get a Invoker
     *
     * @param config
     * @return
     * @throws Exception
     */
    Invoker getInvoker(InvokerConfig config) throws Exception;

    /**
     * pre process a invoker
     *
     * @param invoker
     * @throws Exception
     */
    void preProcess(Invoker invoker) throws Exception;

    /**
     * post process a invoker
     *
     * @param invoker
     * @throws Exception
     */
    void postProcess(Invoker invoker) throws Exception;
}
