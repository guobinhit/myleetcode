package com.hit.basmath.learn.binary_search;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 * <p>
 * Note:
 * <p>
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class _154 {
    private static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
