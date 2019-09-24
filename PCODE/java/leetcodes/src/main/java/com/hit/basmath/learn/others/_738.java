package com.hit.basmath.learn.others;

/**
 * 738. Monotone Increasing Digits
 * <p>
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * <p>
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 * <p>
 * Example 1:
 * <p>
 * Input: N = 10
 * Output: 9
 * <p>
 * Example 2:
 * <p>
 * Input: N = 1234
 * Output: 1234
 * <p>
 * Example 3:
 * <p>
 * Input: N = 332
 * <p>
 * Output: 299
 * <p>
 * Note: N is an integer in the range [0, 10^9].
 */
public class _738 {
    public int monotoneIncreasingDigits(int N) {

        if (N <= 9)
            return N;
        char[] x = String.valueOf(N).toCharArray();

        int mark = x.length;
        for (int i = x.length - 1; i > 0; i--) {
            if (x[i] < x[i - 1]) {
                mark = i - 1;
                x[i - 1]--;
            }
        }
        for (int i = mark + 1; i < x.length; i++) {
            x[i] = '9';
        }
        return Integer.parseInt(new String(x));
    }
}
