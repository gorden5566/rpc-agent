package com.gorden5566.rpc.agent.server;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.gorden5566.rpc.agent.core.util.Consts;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class BootStrap {
    public static void main(String[] args) {
        Command command = new Command();

        JCommander jc = JCommander.newBuilder()
            .addObject(command)
            .programName(getProgramName())
            .build();

        try {
            jc.parse(args);
        } catch (ParameterException e) {
            System.out.println(e.getMessage());
            jc.usage();
            return;
        }

        command.run(jc);
    }

    private static String getProgramName() {
        StringBuilder sb = new StringBuilder();
        sb.append("java -jar ").append(Consts.getProgramName()).append(".jar");
        return sb.toString();
    }
}
