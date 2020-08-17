package com.gorden5566.rpc.agent.core.util;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class ExtensionLoader {
    /**
     * 加载第一个 spi 实现
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T loadFirst(Class<T> clazz) {
        Iterator<T> iterator = loadAll(clazz);
        if (!iterator.hasNext()) {
            throw new IllegalStateException(String.format(
                "No implementation defined in /META-INF/services/%s, please check whether the file exists and has the right implementation class!",
                clazz.getName()));
        }
        return iterator.next();
    }

    /**
     * 加载所有的 spi 实现
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Iterator<T> loadAll(Class<T> clazz) {
        ServiceLoader<T> loader = ServiceLoader.load(clazz);

        return loader.iterator();
    }
}
