package com.hit.basmath.learn.array_and_string;

/**
 * 66. Plus One
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * <p>
 * Example 3:
 * <p>
 * Input: [9,9]
 * Output: [1,0,0]
 * Explanation: The array represents the integer 99.
 */
public class _66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        /**
         * Iterate digits from last element,
         * if the last element of digits is less than 9,
         * we only let this element plus 1, it's satisfied,
         * else this element is't less than 9, set this element is 0, and go on
         */
        for (int i = length - 1; i >= 0; i--) {
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
        int[] newDigits = new int[length + 1];

        /**
         * set newDigits[0] = 1, and others element of newDigits is default 0
         */
        newDigits[0] = 1;
        return newDigits;
    }
}
