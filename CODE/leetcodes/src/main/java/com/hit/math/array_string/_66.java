package com.hit.math.array_string;

import com.hit.math.utils.CommonUtils;

/**
 * 66. Plus One
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class _66 {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        /**
         * Iterate digits from last element,
         * if the last element of digits is less than 9,
         * we only let this element plus 1, it's satisfied,
         * else this element is't less than 9, set this element is 0, and go on
         */
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        /**
         * If program is execute this sentence, it's mean all element of digits is 9,
         * so, create a new array and length is digits.length
         */
        int[] newDigits = new int[n + 1];
        /**
         * set newDigits[0] = 1, and others element of newDigits is default 0
         */
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {4, 3, 2, 1};
        int[] nums3 = {9, 9, 9};
        System.out.println(CommonUtils.printIntArray2String(_66.plusOne(nums)));
        System.out.println(CommonUtils.printIntArray2String(_66.plusOne(nums2)));
        System.out.println(CommonUtils.printIntArray2String(_66.plusOne(nums3)));
    }
}
