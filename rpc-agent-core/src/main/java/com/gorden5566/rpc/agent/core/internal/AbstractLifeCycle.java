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
                if (state == STARTED || state == STARTING) {
                    return;
                }
                setStarting();
                doStart();
                setStarted();
            } catch (Throwable e) {
                setFailed(e);
                throw e;
            }
        }
    }

    @Override
    public void stop() throws Exception {
        synchronized (this) {
            try {
                if (state == STOPPING || state == STOPPED) {
                    return;
                }
                setStopping();
                doStop();
                setStopped();
            } catch (Throwable e) {
                setFailed(e);
                throw e;
            }
        }
    }

    @Override
    public boolean isRunning() {
        return state == STARTED || state == STARTING;
    }

    @Override
    public boolean isStarted()
    {
        return state == STARTED;
    }

    @Override
    public boolean isStarting()
    {
        return state == STARTING;
    }

    @Override
    public boolean isStopping()
    {
        return state == STOPPING;
    }

    @Override
    public boolean isStopped()
    {
        return state == STOPPED;
    }

    @Override
    public boolean isFailed()
    {
        return state == FAILED;
    }

    private void setStarting() {
        this.state = STARTING;
    }

    private void setStarted() {
        this.state = STARTED;
    }

    private void setStopping() {
        this.state = STOPPING;
    }

    private void setStopped() {
        this.state = STOPPED;
    }

    private void setFailed(Throwable t) {
        this.state = FAILED;
    }
}
