package com.hit.basmath.learn.others;

/**
 * 303. Range Sum Query - Immutable
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * <p>
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * Note:
 * 1. You may assume that the array does not change.
 * 2. There are many calls to sumRange function.
 */
public class _303 {
    class NumArray {
        private int[] sums;

        public NumArray(int[] nums) {
            if (nums.length != 0) {
                sums = new int[nums.length];

                sums[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    sums[i] = nums[i] + sums[i - 1];
                }
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sums[j] : sums[j] - sums[i - 1];
        }
    }
}
