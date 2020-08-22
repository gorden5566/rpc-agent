package com.gorden5566.rpc.agent.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.gorden5566.rpc.agent.core.Agent;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.util.Consts;
import com.gorden5566.rpc.agent.core.util.JsonUtils;
import com.gorden5566.rpc.agent.server.util.NetUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class Command {
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final int DEFAULT_PORT = 8080;

    @Parameter(names = {"-h", "--help"}, order = 1, description = "print help message")
    private boolean help = false;

    @Parameter(names = {"-d", "--demo"}, order = 2, description = "export config demo")
    private boolean demo = false;

    @Parameter(names = {"-f", "--file"}, order = 3, description = "[client mode] specified config file")
    private String file = "request.json";

    @Parameter(names = {"-s", "--server"}, order = 4, description = "[server mode] enable server mode")
    private boolean server = false;

    @Parameter(names = {"-l", "--local"}, order = 5, description = "[server mode] use loopback address")
    private boolean local = false;

    @Parameter(names = {"-p", "--port"}, order = 6, description = "[server mode] specified server port")
    private int port = DEFAULT_PORT;

    @Parameter(names = {"-v", "--version"}, order = 7, description = "print version info")
    private boolean version = false;

    public void run(JCommander jc) {
        if (help) {
            jc.usage();
            return;
        }

        if (version) {
            System.out.println(Consts.getProgramName() + ", version " + Consts.getVersion());
            return;
        }

        if (server) {
            String host = local ? DEFAULT_HOST : NetUtils.getFirstLocalIp();
            AgentServer server = new JettyAgentServer(host, port);
            try {
                server.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        if (demo) {
            export("demo.json");
            return;
        }

        if (StringUtils.isNotBlank(file)) {
            boolean success = process(file);
            if (!success) {
                jc.usage();
            }
            return;
        }

        jc.usage();
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

    private boolean process(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("config file not exist [" + fileName + "]");
            return false;
        }

        RpcRequestConfig config = null;
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            config = JSON.parseObject(bytes, RpcRequestConfig.class);
        } catch (Exception e) {
            System.out.println("read config file failed: " + e.getMessage());
        }

        try {
            String result = Agent.invoke(config);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("remote call failed: " + e.getMessage());
        }
        return true;
    }
}
