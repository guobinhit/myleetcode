package com.hit.basmath.learn.others;

/**
 * 263. Ugly Number
 * <p>
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * <p>
 * Example 2:
 * <p>
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * <p>
 * Example 3:
 * <p>
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 */
public class _263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num % 2 == 0) {
            return isUgly(num / 2);
        }
        if (num % 3 == 0) {
            return isUgly(num / 3);
        }
        if (num % 5 == 0) {
            return isUgly(num / 5);
        }
        return false;
    }
}
