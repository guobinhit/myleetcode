package com.hit.basmath.learn.array_string;

/**
 * 724. Find Pivot Index
 * <p>
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal
 * to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * <p>
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * <p>
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * <p>
 * Note:
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class _724 {
    /**
     * Space: O(1)
     * Time: O(n)
     */
    public static int pivotIndex(int[] nums) {
        int total = 0;
        /**
         * Get sum of all element
         */
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        /**
         * Iterate all element of nums
         */
        for (int i = 0; i < nums.length; sum += nums[i++]) {
            /**
             * If the following conditions are established，
             * it's mean sum of left of index i is equal sum of right of index i
             */
            if (sum * 2 == total - nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Space: O(n)
     * Time: O(n)
     */
    public static int pivotIndex2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && 0 == sums[nums.length - 1] - sums[i] || (i > 0 && sums[i - 1] == sums[nums.length - 1] - sums[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 7, 3, 6, 5, 6};
        System.out.println("Space: O(1), Time: O(n): " + _724.pivotIndex(testArray));
        System.out.println("Space: O(n), Time: O(n): " + _724.pivotIndex2(testArray));
    }
}
