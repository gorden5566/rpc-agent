package com.gorden5566.rpc.agent.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class HttpUtils {

    /**
     * write json string to response
     *
     * @param response
     * @param jsonString
     * @throws IOException
     */
    public static void writeJson(HttpServletResponse response, String jsonString) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonString);
    }

    /**
     * read request body as string
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getBodyString(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
