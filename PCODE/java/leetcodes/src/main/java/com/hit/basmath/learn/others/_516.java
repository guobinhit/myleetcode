package com.hit.basmath.learn.others;

/**
 * 516. Longest Palindromic Subsequence
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "bbbab"
 * <p>
 * Output: 4
 * <p>
 * One possible longest palindromic subsequence is "bbbb".
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: 2
 * <p>
 * One possible longest palindromic subsequence is "bb".
 */
public class _516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
