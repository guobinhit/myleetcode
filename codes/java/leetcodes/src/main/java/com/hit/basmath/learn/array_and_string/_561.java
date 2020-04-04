package com.hit.basmath.learn.array_and_string;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * <p>
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * <p>
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 */
public class _561 {
    public int arrayPairSum(int[] nums) {
        /**
         * Use Arrays.sort() method let nums sort from small to big
         */
        Arrays.sort(nums);

        int aimSum = 0;
        /**
         * According to the topic of this question,
         * we can know when nums sorted from small to big,
         * only accumulate element of nums that index is 0、2、4 ... 2n that will do
         */
        for (int i = 0; i < nums.length; i = i + 2) {
            aimSum = aimSum + nums[i];
        }
        return aimSum;
    }
}
