package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 583. Delete Operation for Two Strings
 * <p>
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 * <p>
 * Example 1:
 * <p>
 * Input: "sea", "eat"
 * Output: 2
 * <p>
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * <p>
 * Note:
 * <p>
 * 1. The length of given words won't exceed 500.
 * 2. Characters in given words can only be lower-case letters.
 */
public class _583 {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[2][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[1], 0);
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[1][j] = dp[0][j - 1] + 1;
                } else {
                    dp[1][j] = Math.max(dp[0][j], dp[1][j - 1]);
                }
            }
            System.arraycopy(dp[1], 0, dp[0], 0, m + 1);
        }
        return m + n - 2 * dp[1][m];
    }
}
