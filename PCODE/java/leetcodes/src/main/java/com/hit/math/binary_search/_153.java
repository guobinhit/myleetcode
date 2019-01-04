package com.hit.math.binary_search;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * <p>
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * <p>
 * Output: 0
 */
public class _153 {
    private static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] > nums[right]) {
            return nums[right];
        }
        return nums[left];
    }
}
