package com.gorden5566.rpc.agent.server;

import java.io.FileOutputStream;
import java.io.IOException;

import com.alibaba.fastjson.JSONArray;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.util.JsonUtils;
import com.gorden5566.rpc.agent.server.util.NetUtils;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class Command {

    @Parameter(names = {"-h", "--help"}, order = 1, description = "print help message")
    private boolean help = false;

    @Parameter(names = {"-d", "--demo"}, order = 2, description = "export config demo")
    private boolean demo = false;

    @Parameter(names = {"-l", "--local"}, order = 4, description = "[server mode] use loopback address")
    private boolean local = false;

    @Parameter(names = {"-p", "--port"}, order = 5, description = "[server mode] specified server port")
    private int port = 8080;

    public void run(JCommander jc) {
        if (help) {
            jc.usage();
            return;
        }

        if (demo) {
            export("demo.json");
            return;
        }

        String host = local ? "127.0.0.1" : NetUtils.getFirstLocalIp();
        AgentServer server = new JettyAgentServer(host, port);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void export(String fileName) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)){
            RpcRequestConfig config = new RpcRequestConfig();
            config.setPort(1234);
            config.setHost("127.0.0.1");
            config.setService("com.gorden5566.demo.service.HelloService");
            config.setMethod("sayHello");
            config.setTag("test");
            config.setParams(new JSONArray());

            String str = JsonUtils.toPrettyJson(config);
            outputStream.write(str.getBytes());
            outputStream.flush();

            System.out.println("write config file: " + fileName);
        } catch (IOException e) {
            System.out.println("write config file failed: " + e.getMessage());
        }
    }
}
