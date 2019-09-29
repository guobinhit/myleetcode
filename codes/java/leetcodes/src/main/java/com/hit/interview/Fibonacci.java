package com.hit.interview;

/**
 * author:Charies Gavin
 * date:2019/1/7,11:16
 * https:github.com/guobinhit
 * description: 斐波那契数列
 */
public class Fibonacci {
    /**
     * 斐波那契数列(递归版)
     *
     * @param i
     * @return
     */
    private static int fibonacciRecursion(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return fibonacciRecursion(i - 1) + fibonacciIterationCache(i - 2);
    }


    private static int[] finCache = new int[100000];

    /**
     * 斐波那契数列(迭代缓存版)
     */
    private static int fibonacciIterationCache(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (finCache[i] != 0) {
            return finCache[i];
        }
        finCache[i] = fibonacciIterationCache(i - 1) + fibonacciIterationCache(i - 2);
        return finCache[i];
    }
}
