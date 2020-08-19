package com.gorden5566.rpc.agent.core.internal;

import com.gorden5566.rpc.agent.core.spi.RpcFormatter;
import com.gorden5566.rpc.agent.core.util.JsonUtils;

/**
 * @author gorden5566
 * @date 2020/08/20
 */
public class DefaultRpcFormatter implements RpcFormatter {
    @Override
    public String formatResponse(RpcResponse response) {
        if (response == null) {
            return null;
        }
        if (RpcResponse.isSuccess(response)) {
            Object data = response.getData();
            if (data != null && data instanceof String) {
                return JsonUtils.toPrettyJson(JsonUtils.fromJson((String) data));
            }
        }
        return JsonUtils.toPrettyJson(response);
    }
}
