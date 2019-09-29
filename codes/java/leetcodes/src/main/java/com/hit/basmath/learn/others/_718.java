package com.hit.basmath.learn.others;

/**
 * 718. Maximum Length of Repeated Subarray
 * <p>
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 * <p>
 * Note:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class _718 {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) return 0;
        int m = A.length;
        int n = B.length;
        int max = 0;
        //dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}
