package com.gorden5566.rpc.agent.core.util;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Supplier;

/**
 * @author gorden5566
 * @date 2020/08/17
 */
public class ExtensionLoader {
    public static <T> T loadFirst(Class<T> clazz, Supplier<T> supplier) {
        Iterator<T> iterator = loadAll(clazz);
        if (!iterator.hasNext()) {
            return supplier.get();
        }
        return iterator.next();
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
