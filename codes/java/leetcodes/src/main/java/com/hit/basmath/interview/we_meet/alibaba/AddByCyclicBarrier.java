package com.hit.basmath.interview.we_meet.alibaba;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/6,上午11:26
 * @description
 */
public class AddByCyclicBarrier {
    private int[] arr;
    private volatile int total = 0;

    public AddByCyclicBarrier(int size) {
        arr = new int[size];
        for (int i = 1; i <= size; i++) {
            arr[i - 1] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        AddByCyclicBarrier cyclicBarrier = new AddByCyclicBarrier(10000);
        cyclicBarrier.addNumber();
    }

    public void addNumber() throws InterruptedException, BrokenBarrierException {
        int length = arr.length;
        CyclicBarrier barrier = new CyclicBarrier(5);
        System.out.println("启5个线程，并发对 1 ~ " + arr.length + " 之间的数字进行求和，并打印结果");
        for (int j = 0; j < length; j += (length / 5)) {
            MyThread task;
            if ((j + (length / 5)) <= length) {
                task = new MyThread(arr, j, j + (length / 5), barrier);
            } else {
                task = new MyThread(arr, j, length, barrier);
            }
            new Thread(task).start();
        }
        barrier.await();
        System.out.println("1 ~ " + arr.length + " 之间的数字和为 " + total);
    }

    private class MyThread implements Runnable {
        int[] arr;
        int startIndex;
        int endIndex;
        CyclicBarrier barrier;

        public MyThread(int[] arr, int startIndex, int endIndex, CyclicBarrier barrier) {
            this.arr = arr;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += arr[i];
            }
            synchronized (MyThread.class) {
                total += sum;
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 计算完毕，累计求和 " + sum);
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }
}
