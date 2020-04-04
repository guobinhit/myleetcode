package com.hit.basmath.learn.array_and_string;

/**
 * 209. Minimum Size Subarray Sum
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * <p>
 * Output: 2
 * <p>
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class _209 {
    /**
     * time complexity is O(n).
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int headIndex = 0, tempIndex = 0, sum = 0, min = Integer.MAX_VALUE;
        /**
         * Iterate nums.length times
         */
        while (tempIndex < nums.length) {
            /**
             * Every iteration let sum = sum + nums[tempIndex++], keep sum increase
             */
            sum += nums[tempIndex++];
            /**
             * If sum >= s is true, it's mean accumulative sum is bigger than s,
             * so we should handle this sum, let min = Math.min(min, tempIndex - headIndex)
             * and in order to keep sum is effective, let sum -= nums[headIndex++], go ahead
             */
            while (sum >= s) {
                min = Math.min(min, tempIndex - headIndex);
                sum -= nums[headIndex++];
            }
        }
        /**
         * If min == Integer.MAX_VALUE is true, it's mean no data satisfied condition,
         * so let min is 0, else let min is itself and return
         */
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
