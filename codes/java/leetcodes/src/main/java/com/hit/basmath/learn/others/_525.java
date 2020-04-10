package com.hit.basmath.learn.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 * <p>
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1]
 * Output: 2
 * <p>
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 2:
 * <p>
 * Input: [0,1,0]
 * Output: 2
 * <p>
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class _525 {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }
}
