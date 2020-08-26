package com.gorden5566.rpc.agent.core.internal;

/**
 * @author gorden5566
 * @date 2020/08/27
 */
public abstract class AbstractLifeCycle implements LifeCycle {
    private final int FAILED = -1, STOPPED = 0, STARTING = 1, STARTED = 2, STOPPING = 3;
    private volatile int state = STOPPED;

    /**
     * 处理start的逻辑
     *
     * @throws Exception
     */
    protected abstract void doStart() throws Exception;

    /**
     * 处理stop的逻辑
     *
     * @throws Exception
     */
    protected abstract void doStop() throws Exception;

    @Override
    public void start() throws Exception {
        synchronized (this) {
            try {
                doStart();
            } catch (Exception e) {
                throw e;
            } catch (Error e) {
                throw e;
            }
        }
    }

    @Override
    public void stop() throws Exception {
        synchronized (this) {
            try {
                doStop();
            } catch (Exception e) {
                throw e;
            } catch (Error e) {
                throw e;
            }
        }
    }

    @Override
    public boolean isStarted() {
        return state == STARTED;
    }

    @Override
    public boolean isStopped() {
        return state == STOPPED;
    }
}
