package com.hit.basmath.learn.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array
 * <p>
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * <p>
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class _697 {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()) {
            if (value[0] > degree) {
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree) {
                res = Math.min(value[2] - value[1] + 1, res);
            }
        }
        return res;
    }
}
