package com.hit.math.binary_search;

/**
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * <p>
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * <p>
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * <p>
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */
public class _50 {
    public double myPow(double x, int n) {
        double temp;

        if (n == 0) {
            return 1;
        }

        temp = myPow(x, n / 2);

        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / x;
            }
        }
    }
}
