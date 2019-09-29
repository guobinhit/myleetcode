package com.hit.basmath.learn.others;

/**
 * 664. Strange Printer
 * <p>
 * There is a strange printer with the following two special requirements:
 * <p>
 * 1. The printer can only print a sequence of the same character each time.
 * 2. At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
 * <p>
 * Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.
 * <p>
 * Example 1:
 * <p>
 * Input: "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * <p>
 * Example 2:
 * <p>
 * Input: "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 * <p>
 * Hint: Length of the given string will not exceed 100.
 */
public class _664 {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i < n - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 2;
            }
        }

        for (int len = 2; len < n; len++) {
            for (int start = 0; start + len < n; start++) {
                dp[start][start + len] = len + 1;
                for (int k = 0; k < len; k++) {
                    int temp = dp[start][start + k] + dp[start + k + 1][start + len];
                    dp[start][start + len] = Math.min(
                            dp[start][start + len],
                            s.charAt(start + k) == s.charAt(start + len) ? temp - 1 : temp
                    );
                }
            }
        }

        return dp[0][n - 1];
    }
}
