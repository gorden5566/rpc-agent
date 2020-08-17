package com.gorden5566.rpc.agent.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class JsonUtils {
    public static String toPrettyJson(Object object) {
        return JSON.toJSONString(object, true);
    }

    public static JSONObject fromJson(String json) {
        return JSON.parseObject(json);
    }
}
