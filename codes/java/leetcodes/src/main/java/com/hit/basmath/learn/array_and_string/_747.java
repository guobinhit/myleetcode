package com.hit.basmath.learn.array_and_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 747. Largest Number Greater Than Twice of Others
 * <p>
 * In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, otherwise return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x. The index of value 6 is 1, so we return 1.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 * <p>
 * Note:
 * <p>
 * 1. nums will have a length in the range [1, 50].
 * 2. Every nums[i] will be an integer in the range [0, 99].
 */
public class _747 {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }

        /**
         * Initial variable of max、secondMax and index
         */
        int max = Integer.MIN_VALUE + 1;
        int secondMax = Integer.MIN_VALUE;
        int index = 0;

        /**
         * Iterate all element of nums
         */
        for (int i = 0; i < nums.length; i++) {
            /**
             * If nums[i] > max，exchange max and secondMax value each other,
             * and record index of i
             */
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] != max && nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        /**
         * We have recorded max value、secondMax value and max value index
         * so, if max >= secondMax * 2，max index is satisfied
         */
        if (secondMax * 2 <= max) {
            return index;
        }
        return -1;
    }
}
