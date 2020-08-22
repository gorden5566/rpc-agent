package com.gorden5566.rpc.agent.core;

import com.gorden5566.rpc.agent.core.internal.InstanceFactory;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.util.Consts;

/**
 * @author gorden5566
 * @date 2020/08/22
 */
public class Agent {
    /**
     * call remote method
     *
     * @param config
     * @return
     * @throws Exception
     */
    public static String invoke(RpcRequestConfig config) throws Exception {
        return InstanceFactory.getInvokerProxy().invoke(config);
    }

    /**
     * set programName
     *
     * @param programName
     */
    public static void setProgramName(String programName) {
        Consts.setProgramName(programName);
    }
}
