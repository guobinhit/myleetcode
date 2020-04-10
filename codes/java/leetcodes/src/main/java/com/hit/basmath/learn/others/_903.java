package com.hit.basmath.learn.others;

/**
 * 903. Valid Permutations for DI Sequence
 * <p>
 * We are given S, a length n string of characters from the set {'D', 'I'}. (These letters stand for "decreasing" and "increasing".)
 * <p>
 * A valid permutation is a permutation P[0], P[1], ..., P[n] of integers {0, 1, ..., n}, such that for all i:
 * <p>
 * If S[i] == 'D', then P[i] > P[i+1], and;
 * If S[i] == 'I', then P[i] < P[i+1].
 * How many valid permutations are there?  Since the answer may be large, return your answer modulo 10^9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: "DID"
 * Output: 5
 * Explanation:
 * The 5 valid permutations of (0, 1, 2, 3) are:
 * (1, 0, 3, 2)
 * (2, 0, 3, 1)
 * (2, 1, 3, 0)
 * (3, 0, 2, 1)
 * (3, 1, 2, 0)
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * S consists only of characters from the set {'D', 'I'}.
 */
public class _903 {
    public int numPermsDISequence(String S) {
        int n = S.length(), mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = 1;
        for (int i = 0; i < n; i++)
            if (S.charAt(i) == 'I')
                for (int j = 0, cur = 0; j < n - i; j++)
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % mod;
            else
                for (int j = n - i - 1, cur = 0; j >= 0; j--)
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % mod;
        return dp[n][0];
    }
}
