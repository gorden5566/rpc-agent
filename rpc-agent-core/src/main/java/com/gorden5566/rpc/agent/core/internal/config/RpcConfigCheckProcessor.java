package com.gorden5566.rpc.agent.core.internal.config;

import com.alibaba.fastjson.JSONArray;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.RpcResponse;
import org.apache.commons.lang.StringUtils;

/**
 * @author gorden5566
 * @date 2020/08/26
 */
public class RpcConfigCheckProcessor implements RpcConfigProcessor {
    @Override
    public RpcResponse processConfig(RpcRequestConfig config) {
        if (config == null) {
            return RpcResponse.newError("invalid parameters", "config cannot be null");
        }

        if (StringUtils.isBlank(config.getHost())) {
            return RpcResponse.newError("invalid parameters", "[host] cannot be empty");
        }

        if (config.getPort() == null) {
            return RpcResponse.newError("invalid parameters", "[port] cannot be empty");
        }

        if (StringUtils.isBlank(config.getService())) {
            return RpcResponse.newError("invalid parameters", "[service] cannot be empty");
        }

        if (StringUtils.isBlank(config.getMethod())) {
            return RpcResponse.newError("invalid parameters", "[method] cannot be empty");
        }

        if (config.getParams() == null) {
            return RpcResponse.newError("invalid parameters", "[params] cannot be null");
        }

        if (config.getParamTypes() != null) {
            JSONArray params = config.getParams();
            JSONArray paramTypes = config.getParamTypes();
            if (params.size() != paramTypes.size()) {
                return RpcResponse.newError("invalid parameters", "[paramTypes] should matches with [params]");
            }
        }

        return null;
    }
}
