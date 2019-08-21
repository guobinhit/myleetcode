package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 260. Single Number III
 * <p>
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * <p>
 * Note:
 * <p>
 * 1. The order of the result is not important. So in the above example, [5, 3] is also correct.
 * 2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class _260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff = Integer.highestOneBit(diff);

        int[] result = new int[2];
        Arrays.fill(result, 0);
        for (int num : nums) {
            if ((diff & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
