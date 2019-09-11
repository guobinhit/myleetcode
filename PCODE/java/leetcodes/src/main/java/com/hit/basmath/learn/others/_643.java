package com.hit.basmath.learn.others;

/**
 * 643. Maximum Average Subarray I
 * <p>
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * Note:
 * <p>
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */
public class _643 {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }
}
