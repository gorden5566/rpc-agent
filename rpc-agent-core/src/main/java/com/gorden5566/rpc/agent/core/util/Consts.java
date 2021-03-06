package com.gorden5566.rpc.agent.core.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author gorden5566
 * @date 2020/08/22
 */
public class Consts {
    private static String programName = "rpc-agent";
    private static String version = "unknown";
    private static String author = "unknown";

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

        String implVendor = pack.getImplementationVendor();
        if (StringUtils.isNotBlank(implVendor)) {
            author = implVendor;
        }
    }

    /**
     * get program name
     *
     * @return
     */
    public static String getProgramName() {
        return programName;
    }

    /**
     * set program name
     *
     * @param programName
     */
    public static void setProgramName(String programName) {
        Consts.programName = programName;
    }

    /**
     * get agent version
     *
     * @return
     */
    public static String getVersion() {
        return version;
    }

    /**
     * get author
     *
     * @return
     */
    public static String getAuthor() {
        return author;
    }
}
