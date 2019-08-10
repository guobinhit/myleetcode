package com.hit.math.binary_search;

/**
 * 287. Find the Duplicate Number
 * <p>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * <p>
 * Note:
 * <p>
 * 1. You must not modify the array (assume the array is read only).
 * 2. You must use only constant, O(1) extra space.
 * 3. Your runtime complexity should be less than O(n2).
 * 4. There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class _287 {
    /**
     * Binary Search + Pigeonhole Principle
     * <p>
     * https://en.wikipedia.org/wiki/Pigeonhole_principle
     *
     * @param nums pending array
     * @return duplicate number
     */
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = numBelow(nums, mid);
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int numBelow(int[] nums, int target) {
        int result = 0;
        for (int num : nums) {
            if (num <= target) {
                result++;
            }
        }
        return result;
    }
}
