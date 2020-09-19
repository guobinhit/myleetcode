package com.hit.basmath.learn.hash_table;

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
    /**
     * Solution 1: Violence method
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * Solution 2: Two pass hash table
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            aMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (aMap.containsKey(complement) && aMap.get(complement) != i) {
                return new int[]{i, aMap.get(complement)};
            }
        }
        return null;
    }

    /**
     * Solution 3: One pass hash table
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (aMap.containsKey(complement)) {
                return new int[]{aMap.get(complement), i};
            }
            aMap.put(nums[i], i);
        }
        return null;
    }
}
