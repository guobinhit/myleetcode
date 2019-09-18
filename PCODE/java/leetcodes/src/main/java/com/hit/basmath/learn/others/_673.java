package com.hit.basmath.learn.others;

/**
 * 673. Number of Longest Increasing Subsequence
 * <p>
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * <p>
 * Example 2:
 * <p>
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * <p>
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class _673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) cnt[i] += cnt[j];
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i]) res += cnt[i];
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
