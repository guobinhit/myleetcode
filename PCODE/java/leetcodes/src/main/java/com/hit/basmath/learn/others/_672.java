package com.hit.basmath.learn.others;

/**
 * 672. Bulb Switcher II
 * <p>
 * There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.
 * <p>
 * Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:
 * <p>
 * Flip all the lights.
 * Flip lights with even numbers.
 * Flip lights with odd numbers.
 * Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, m = 1.
 * Output: 2
 * Explanation: Status can be: [on], [off]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2, m = 1.
 * Output: 3
 * Explanation: Status can be: [on, off], [off, on], [off, off]
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3, m = 1.
 * Output: 4
 * Explanation: Status can be: [off, on, off], [on, off, on], [off, off, off], [off, on, on].
 * <p>
 * Note: n and m both fit in range [0, 1000].
 */
public class _672 {
    public int flipLights(int n, int m) {
        if (m == 0) return 1;
        if (n <= 0 || m < 0) return 0;

        if (n == 1) return 2;
        else if (n == 2) return (m == 1) ? 3 : 4;
        else return (m == 1) ? 4 : ((m == 2) ? 7 : 8);
    }
}
