package com.hit.basmath.learn.array_string;

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
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
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

    /**
     * time complexity is O(n log n).
     *
     * @param s
     * @param nums
     * @return
     */
    private static int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int binarySearch(int low, int high, int key, int[] sums) {
        while (low <= high) {
            int middle = (low + high) / 2;
            if (sums[middle] >= key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(_209.minSubArrayLen(7, nums));
        System.out.println(_209.solveNLogN(7, nums));
    }
}
