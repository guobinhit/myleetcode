package com.hit.basmath.learn.others;

/**
 * 440. K-th Smallest in Lexicographical Order
 * <p>
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 * <p>
 * Note: 1 ≤ k ≤ n ≤ 109.
 * <p>
 * Example:
 * <p>
 * Input:
 * n: 13   k: 2
 * <p>
 * Output:
 * 10
 * <p>
 * Explanation:
 * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 */
public class _440 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    //use long in case of overflow
    private int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
