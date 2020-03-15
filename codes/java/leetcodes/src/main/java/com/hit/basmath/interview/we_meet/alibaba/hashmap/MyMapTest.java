package com.hit.basmath.interview.we_meet.alibaba.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/6,上午11:51
 * @description
 */
public class MyMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            map.put("key" + i, "value" + i);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println("key: " + "key" + i + "---" + "value: " + map.get("key" + i));
        }
        Long t2 = System.currentTimeMillis();
        System.out.println("MyHashMap耗时：" + (t2 - t1));
        System.out.println("-------------------HashMap-------------------------");
        Map<String, String> hashMap = new HashMap<>();
        Long t3 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            hashMap.put("key" + i, "value" + i);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println("key: " + "key" + i + "---" + "value: " + hashMap.get("key" + i));
        }
        Long t4 = System.currentTimeMillis();
        System.out.println("JDK的HashMap耗时：" + (t4 - t3));
    }
}
