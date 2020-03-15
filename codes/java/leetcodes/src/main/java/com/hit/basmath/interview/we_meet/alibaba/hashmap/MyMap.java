package com.hit.basmath.interview.we_meet.alibaba.hashmap;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/6,上午11:47
 * @description
 */
public interface MyMap<K, V> {
    /**
     * put方法
     *
     * @param k
     * @param v
     * @return
     */
    V put(K k, V v);

    /**
     * get方法
     *
     * @param k
     * @return
     */
    V get(K k);

    int size();

    /**
     * Entry内部接口
     *
     * @param <K>
     * @param <V>
     */
    interface Entry<K, V> {
        /**
         * 根据entry对象获取key值
         *
         * @return
         */
        K getKey();

        /**
         * 根据entry对象获取value值
         *
         * @return
         */
        V getValue();
    }
}
