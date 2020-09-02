package com.gorden5566.rpc.agent.console;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.gorden5566.rpc.agent.core.Agent;
import com.gorden5566.rpc.agent.core.internal.InstanceFactory;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.util.Consts;
import com.gorden5566.rpc.agent.core.util.JsonUtils;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class Command {
    @Parameter(names = {"-h", "--help"}, order = 1, description = "print help message")
    private boolean help = false;

    @Parameter(names = {"-d", "--demo"}, order = 2, description = "export config demo")
    private boolean demo = false;

    @Parameter(names = {"-f", "--file"}, order = 3, description = "specified config file")
    private String file = "request.json";

    @Parameter(names = {"-v", "--version"}, order = 7, description = "print version info")
    private boolean version = false;

    public void run(JCommander jc) {
        if (help) {
            jc.usage();
            return;
        }

        if (version) {
            System.out.println("name: " + Consts.getProgramName());
            System.out.println("version: " + Consts.getVersion());
            System.out.println("author: " + Consts.getAuthor());
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
            RpcRequestConfig config = InstanceFactory.getRpcConfigParser().getConfigSample();

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

        Agent agent = Agent.newInstance();
        try {
            agent.invoke(config);
        } catch (Exception e) {
            System.out.println("remote call failed: " + e.getMessage());
        } finally {
            agent.finishInvoke();
        }
        return true;
    }
}
