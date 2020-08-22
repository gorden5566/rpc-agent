package com.gorden5566.rpc.agent.core.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author gorden5566
 * @date 2020/08/22
 */
public class Consts {
    private static String programName = "rpc-agent";
    private static String version = "unknown";

    static {
        init();
    }

    private static void init() {
        Package pack = Consts.class.getPackage();

        String implTitle = pack.getImplementationTitle();
        if (StringUtils.isNotBlank(implTitle)) {
            programName = implTitle;
        }

        String implVersion = pack.getImplementationVersion();
        if (StringUtils.isNotBlank(implVersion)) {
            version = implVersion;
        }
    }

    public static String getProgramName() {
        return programName;
    }

    public static void setProgramName(String programName) {
        Consts.programName = programName;
    }

    public static String getVersion() {
        return version;
    }
}
