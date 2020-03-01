package com.hit.basmath.interview.top_interview_questions.medium_collection.dynamic_programming;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class _300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            int val = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    val = Math.max(val, dp[j]);
                }
            }
            dp[i] = val + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
