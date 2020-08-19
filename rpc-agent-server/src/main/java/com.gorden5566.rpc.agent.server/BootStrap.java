package com.gorden5566.rpc.agent.server;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang.StringUtils;

/**
 * @author gorden5566
 * @date 2020/08/19
 */
public class BootStrap {
    private static String SPECIFICATION_TITLE = "rpc-agent-server";
    static {
        String specificationTitle = BootStrap.class.getPackage().getSpecificationTitle();
        if (StringUtils.isNotBlank(specificationTitle)) {
            SPECIFICATION_TITLE = specificationTitle;
        }
    }

    public static void main(String[] args) {
        Command command = new Command();

        JCommander jc = JCommander.newBuilder()
            .addObject(command)
            .programName("java -jar " + SPECIFICATION_TITLE + ".jar")
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
