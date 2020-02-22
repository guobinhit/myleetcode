package com.hit.basmath.learn.others;

/**
 * 674. Longest Continuous Increasing Subsequence
 * <p>
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * <p>
 * Example 2:
 * <p>
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * <p>
 * Note: Length of the array will not exceed 10,000.
 */
public class _674 {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                ans = Math.max(ans, ++anchor);
            } else {
                anchor = 1;
            }
        }
        return ans;
    }
}
