package com.hit.basmath.learn.others;

/**
 * 650. 2 Keys Keyboard
 * <p>
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 * <p>
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * <p>
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 3
 * <p>
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * <p>
 * Note:
 * <p>
 * The n will be in the range [1, 1000].
 */
public class _650 {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j);
                    break;
                }

            }
        }
        return dp[n];
    }
}
