package com.gorden5566.rpc.agent.core.util;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class ExtensionLoader {

    private static Map<Class<?>, Object> extensionMap = new ConcurrentHashMap<>();

    public static <T> T loadFirst(Class<T> clazz, Supplier<T> supplier) {
        T extension = (T) extensionMap.get(clazz);

        if (extension == null) {
            // load first
            extension = loadFirst(clazz);

            // load default
            if (extension == null) {
                extension = supplier.get();
            }

            // cache instance
            if (extension != null) {
                extensionMap.put(clazz, extension);
            }
        }
        return extension;
    }

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
            return null;
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
