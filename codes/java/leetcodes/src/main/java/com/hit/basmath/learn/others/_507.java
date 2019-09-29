package com.hit.basmath.learn.others;

/**
 * 507. Perfect Number
 * <p>
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * <p>
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * <p>
 * Example:
 * <p>
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * <p>
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class _507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;

        return sum == num;
    }
}
