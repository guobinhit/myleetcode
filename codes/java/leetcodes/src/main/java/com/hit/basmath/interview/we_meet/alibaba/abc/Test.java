package com.hit.basmath.interview.we_meet.alibaba.abc;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/6,下午8:16
 * @description
 */
public class Test {
    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread t_a = new Thread(new Thread_ABC(maj, 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj, 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj, 'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }
}
