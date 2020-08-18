package com.gorden5566.rpc.agent.console;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class BootStrap {

    public static void main(String[] args) {
        Command command = new Command();

        JCommander jc = JCommander.newBuilder()
            .addObject(command)
            .programName("java -jar rpc-agent-console.jar")
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
}
