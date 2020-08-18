package com.gorden5566.rpc.agent.core.internal;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public interface RpcRequest {

    /**
     * service name
     *
     * @return
     */
    String getServiceName();

    /**
     * method name
     *
     * @return
     */
    String getMethodName();

    /**
     * request json
     *
     * @return
     */
    String getRequestJson();

    /**
     * req id
     *
     * @return
     */
    String getReqId();

    /**
     * rpc id
     *
     * @return
     */
    String getRpcId();

    /**
     * tag
     *
     * @return
     */
    String getTag();
}
