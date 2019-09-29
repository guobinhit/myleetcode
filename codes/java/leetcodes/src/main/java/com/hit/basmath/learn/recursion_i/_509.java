package com.hit.basmath.learn.recursion_i;

/**
 * 509. Fibonacci Number
 * <p>
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * Example 3:
 * <p>
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 ≤ N ≤ 30.
 */
public class _509 {

    /**
     * Solution 1: Iterative
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param N seed number
     * @return fibonacci number
     */
    public int fib(int N) {
        if (N <= 1)
            return N;

        int a = 0, b = 1;

        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /**
     * Solution 2: Recursive
     * <p>
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     *
     * @param N seed number
     * @return fibonacci number
     */
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    /**
     * Solution 3: Dynamic Programming - Bottom Up Approach
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param N seed number
     * @return fibonacci number
     */
    public int fib3(int N) {
        if (N <= 1)
            return N;

        int[] fib_cache = new int[N + 1];
        fib_cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
        }
        return fib_cache[N];
    }

    /**
     * Solution 4: Dynamic Programming - Top Down Approach
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param N seed number
     * @return fibonacci number
     */
    private int[] fib_cache = new int[31];

    public int fib4(int N) {
        if (N <= 1)
            return N;
        else if (fib_cache[N] != 0)
            return fib_cache[N];
        else
            return fib_cache[N] = fib(N - 1) + fib(N - 2);
    }
}
