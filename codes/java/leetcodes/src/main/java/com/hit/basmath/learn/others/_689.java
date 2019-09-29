package com.hit.basmath.learn.others;

/**
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * <p>
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 * <p>
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 * <p>
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 * <p>
 * Note:
 * <p>
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 */
public class _689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp = new int[4][nums.length];
        int[][] pt = new int[4][nums.length];

        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = i == 0 ? nums[0] : nums[i] + sum[i - 1];
        }
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j - k + 1 < 0) {
                    dp[i][j] = 0;
                } else {
                    int val = j - k < 0 ? sum[j] : dp[i - 1][j - k] + sum[j] - sum[j - k];

                    if (j == 0 || val > dp[i][j - 1]) {
                        dp[i][j] = val;
                        pt[i][j] = j - k + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        pt[i][j] = pt[i][j - 1];
                    }
                }
            }
        }
        int[] ret = new int[3];

        ret[2] = pt[3][nums.length - 1];
        ret[1] = pt[2][ret[2] - 1];
        ret[0] = pt[1][ret[1] - 1];

        return ret;
    }
}
