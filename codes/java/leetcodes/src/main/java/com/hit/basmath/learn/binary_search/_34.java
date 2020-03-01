package com.hit.basmath.learn.binary_search;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class _34 {
    public int[] searchRange(int[] nums, int target) {
        double left = target - 0.5, right = target + 0.5;
        int leftIndex = binarySearch(nums, left);
        int rightIndex = binarySearch(nums, right);
        if (leftIndex == rightIndex) {
            return new int[]{-1, -1};
        } else {
            return new int[]{leftIndex, rightIndex - 1};
        }
    }

    private int binarySearch(int[] nums, double target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
