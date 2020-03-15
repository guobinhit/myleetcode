package com.hit.basmath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/1,下午9:29
 * @description
 */
public class MultiThreadCalculate {
    public static void main(String[] args) throws Exception {
        // 定义一个数组并初始化
        int[] nums = new int[2000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("请输入线程的个数:");
        int count = input.nextInt();
        // 计算每个线程要计算数字的个数
        int numcount = nums.length / count;

        // 声明一个集合存储线程对象
        List<MyThread> list = new ArrayList<>();

        // 循环创建多个线程计算数字之和
        for (int i = 0; i < count; i++) {
            MyThread myThread;
            if (i != count - 1) {
                myThread = new MyThread(nums, i * numcount, (i + 1) * numcount);
            } else {// 最后一个线程
                myThread = new MyThread(nums, i * numcount, nums.length);
            }
            // 启动线程
            myThread.start();
            list.add(myThread);
        }

        // 将计算的线程合并到主线程中
        for (int i = 0; i < list.size(); i++) {
            list.get(i).join();
        }

        // 主线程中计算所有数的和
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total = total + list.get(i).sum;
        }
        System.out.println("所有数之和为：" + total);
    }

    static class MyThread extends Thread {
        // 每个线程计算的数字之和
        public int sum;
        // 要计算的数组
        int[] nums;
        // 开始计算的角标
        int start;
        // 计算的最后一个角标
        int end;

        MyThread(int[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        // 重写运行方法
        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                sum = sum + nums[i];
            }
        }
    }
}