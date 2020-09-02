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
     * set programName
     *
     * @param programName
     */
    public static void setProgramName(String programName) {
        Consts.setProgramName(programName);
    }

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

        System.out.println("reqid: " + getReqId());
        System.out.println(result);

        return result;
    }

    public String getReqId() {
        ParsedRequestConfig config = getRpcContext().getConfig();
        if (config == null) {
            return null;
        }
        return config.getRpcRequest().getReqId();
    }

    public RpcContext getRpcContext() {
        return RpcContext.getContext();
    }

    public void finishInvoke() {
        RpcContext.removeContext();
    }
}
