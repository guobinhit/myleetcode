package com.hit.basmath.learn.others;

/**
 * 829. Consecutive Numbers Sum
 * <p>
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * <p>
 * Example 2:
 * <p>
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * <p>
 * Example 3:
 * <p>
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * <p>
 * Note: 1 <= N <= 10 ^ 9.
 */
public class _829 {
    public int consecutiveNumbersSum(int N) {
        int ans = 1;
        for (int i = 2; i * (i + 1) / 2 <= N; ++i) {
            if ((N - i * (i + 1) / 2) % i == 0) ++ans;
        }
        return ans;
    }
}
