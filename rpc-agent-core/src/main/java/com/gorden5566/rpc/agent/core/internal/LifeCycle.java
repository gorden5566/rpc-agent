package com.gorden5566.rpc.agent.core.internal;

/**
 * @author gorden5566
 * @date 2020/08/27
 */
public interface LifeCycle {

    /**
     * Starts the component.
     *
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * Stops the component.
     *
     * @throws Exception
     */
    void stop() throws Exception;

    /**
     * Check if the component is starting or has been started.
     *
     * @return
     */
    boolean isRunning();

    /**
     * Check if the component has been started.
     *
     * @return
     */
    boolean isStarted();

    /**
     * Check if the component is starting.
     *
     * @return
     */
    boolean isStarting();

    /**
     * Check if the component is stopping.
     *
     * @return
     */
    boolean isStopping();

    /**
     * Check if the component has been stopped.
     *
     * @return
     */
    boolean isStopped();

    /**
     * Check if the component has failed to start or has failed to stop.
     *
     * @return
     */
    boolean isFailed();
}
