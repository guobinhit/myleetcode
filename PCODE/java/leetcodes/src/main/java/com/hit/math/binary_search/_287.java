package com.hit.math.binary_search;

import java.util.Arrays;

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
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int targetIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                targetIndex = i;
                break;
            }
        }

        return nums[targetIndex];
    }
}
