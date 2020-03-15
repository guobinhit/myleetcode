package com.hit.basmath.interview.we_meet.alibaba.abc;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/6,下午8:11
 * @description
 */
public class Thread_ABC implements Runnable {
    //请补充代码
    private Character name;
    private MajusculeABC majusculeABC;

    public Thread_ABC(MajusculeABC majusculeABC, final Character name) {
        this.majusculeABC = majusculeABC;
        this.name = name;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (majusculeABC) {
                if (name.equals('A')) {
                    if (majusculeABC.total.get() % 3 != 0) {
                        try {
                            majusculeABC.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        majusculeABC.printMajuscule(name);
                        count--;
                        majusculeABC.notifyAll();
                    }
                }
                if (name.equals('B')) {
                    if (majusculeABC.total.get() % 3 != 1) {
                        try {
                            majusculeABC.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        majusculeABC.printMajuscule(name);
                        count--;
                        majusculeABC.notifyAll();
                    }
                }
                if (name.equals('C')) {
                    if (majusculeABC.total.get() % 3 != 2) {
                        try {
                            majusculeABC.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        majusculeABC.printMajuscule(name);
                        count--;
                        majusculeABC.notifyAll();
                    }
                }
            }
        }
    }
}
