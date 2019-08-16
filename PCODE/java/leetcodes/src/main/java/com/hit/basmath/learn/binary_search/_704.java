package com.hit.basmath.learn.binary_search;

/**
 * 704. Binary Search
 * <p>
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * <p>
 * Note:
 * <p>
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */
public class _704 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // binary search algorithm
        while (left <= right) {
            // unsigned right means divided 2's n square
            int middle = (left + right) >>> 1;
            // compare target element
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -2, -1, 1, 2, 3};
        System.out.println(search(arr, 2));
    }
}
