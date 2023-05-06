package com.gorden5566.rpc.agent.core;

import com.gorden5566.rpc.agent.core.context.RpcContext;
import com.gorden5566.rpc.agent.core.internal.InstanceFactory;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.config.ParsedRequestConfig;
import com.gorden5566.rpc.agent.core.util.Consts;

/**
 * @author gorden5566
 * @date 2020/08/22
 */
public class Agent {

    /**
     * set program name
     *
     * @param programName
     */
    public static void setProgramName(String programName) {
        Consts.setProgramName(programName);
    }

    /**
     * create a agent
     *
     * @return
     */
    public static Agent newInstance() {
        return new Agent();
    }

    /**
     * call remote method
     *
     * @param config
     * @return
     * @throws Exception
     */
    public String invoke(RpcRequestConfig config) throws Exception {
        RpcContext.getContext().setTag(config.getTag());

        String result = InstanceFactory.getInvokerProxy().invoke(config);

        StringBuilder sb = new StringBuilder();
        sb.append("time: " + System.currentTimeMillis()).append("\r\n")
            .append("reqid: " + getReqId()).append("\r\n")
            .append(result).append("\r\n");
        System.out.println(sb);

        return result;
    }

    /**
     * get request id
     *
     * @return
     */
    public String getReqId() {
        return getRpcContext().getReqId();
    }

    /**
     * get rpc context
     *
     * @return
     */
    public RpcContext getRpcContext() {
        return RpcContext.getContext();
    }

    /**
     * finish a rpc request
     */
    public void finishInvoke() {
        RpcContext.removeContext();
    }
}
