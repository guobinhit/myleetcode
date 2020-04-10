package com.hit.basmath.learn.others;

/**
 * 628. Maximum Product of Three Numbers
 * <p>
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: 6
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: 24
 * <p>
 * Note:
 * <p>
 * 1. The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * 2. Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class _628 {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
