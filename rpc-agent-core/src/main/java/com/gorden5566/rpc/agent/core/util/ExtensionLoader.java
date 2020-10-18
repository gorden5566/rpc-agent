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

    /**
     * load first spi implementation
     *
     * @param clazz spi class
     * @param supplier default implementation
     * @param <T>
     * @return
     */
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
                extensionMap.putIfAbsent(clazz, extension);
            }
        }
        return extension;
    }

    /**
     * load first spi implementation
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
     * load all spi implementation
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
