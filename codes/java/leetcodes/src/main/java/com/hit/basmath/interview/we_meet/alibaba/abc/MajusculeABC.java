package com.hit.basmath.interview.we_meet.alibaba.abc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/6,下午8:12
 * @description
 */
public class MajusculeABC {
    public AtomicInteger total = new AtomicInteger(0);

    //请补充代码
    public void printMajuscule(Character name) {
        System.out.print(name);
        total.incrementAndGet();
    }
}
