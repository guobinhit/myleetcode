package com.hit.math.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * <p>
 * return [0, 1].
 */
public class _1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            // note that the numbers in the array can be negative as well
            if (map.get(target - a) != null) {
                return new int[]{map.get(target - a), i};
            }
            // The following should be after the check above,
            // otherwise it will fail for the case where target = 6 and there's a 3 in the original array.
            map.put(a, i);
        }
        return null;
    }
}
