package com.hit.basmath.learn.array_and_string;

import java.util.Arrays;

/**
 * 189. Rotate Array
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * <p>
 * Output: [5,6,7,1,2,3,4]
 * <p>
 * Explanation:
 * <p>
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * <p>
 * Output: [3,99,-1,-100]
 * <p>
 * Explanation:
 * <p>
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * Could you do it in-place with O(1) extra space?
 */
public class _189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        /**
         * When k is larger than nums.length,
         * mode operation can let us get smallest step number
         */
        k %= nums.length;
        /**
         * If k != 0 is true, execute actual reverse operation
         */
        if (k != 0) {
            /**
             * reverse all element in nums
             */
            reverse(nums, 0, nums.length - 1);
            /**
             * handle first k element in nums
             */
            reverse(nums, 0, k - 1);
            /**
             * handle last nums.length - k element in nums
             */
            reverse(nums, k, nums.length - 1);
        } else {
            /**
             * When k is equal to nums.length, it's mean nums don't need change
             */
            return;
        }
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            /**
             * move two pointer at one times, can improve effective
             */
            start++;
            end--;
        }
    }
}
