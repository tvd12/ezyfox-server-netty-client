package com.tvd12.ezyfoxserver.client.socket;

public abstract class EzySimpleSocketEventLoop extends EzySocketEventLoop {

    protected String threadName;
    protected int threadPoolSize = 1;
    
    protected final void eventLoop() {
        getLogger().info(currentThreadName() + " event loop has started");
        eventLoop0();
        getLogger().info(currentThreadName() + " event loop has stopped");
    }
    
    protected abstract void eventLoop0();

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    @Override
    protected String threadName() {
        return threadName;
    }

    @Override
    protected int threadPoolSize() {
        return threadPoolSize;
    }
    
    private String currentThreadName() {
        return Thread.currentThread().getName();
    }
}
