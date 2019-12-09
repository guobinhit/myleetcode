package com.hit.basmath.learn.others;

/**
 * 902. Numbers At Most N Given Digit Set
 * <p>
 * We have a sorted set of digits D, a non-empty subset of {'1','2','3','4','5','6','7','8','9'}.  (Note that '0' is not included.)
 * <p>
 * Now, we write numbers using these digits, using each digit as many times as we want.  For example, if D = {'1','3','5'}, we may write numbers such as '13', '551', '1351315'.
 * <p>
 * Return the number of positive integers that can be written (using the digits of D) that are less than or equal to N.
 * <p>
 * Example 1:
 * <p>
 * Input: D = ["1","3","5","7"], N = 100
 * Output: 20
 * Explanation:
 * The 20 numbers that can be written are:
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * <p>
 * Example 2:
 * <p>
 * Input: D = ["1","4","9"], N = 1000000000
 * Output: 29523
 * Explanation:
 * We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
 * 81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
 * 2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
 * In total, this is 29523 integers that can be written using the digits of D.
 * <p>
 * Note:
 * <p>
 * D is a subset of digits '1'-'9' in sorted order.
 * 1 <= N <= 10^9
 */
public class _902 {
    public int atMostNGivenDigitSet(String[] D, int N) {
        char[] digits = new char[D.length];
        for (int i = 0; i < D.length; i++) digits[i] = D[i].toCharArray()[0];
        String str_N = Integer.toString(N);

        int len_N = str_N.length();
        int len_D = D.length;
        int res = 0;

        int checkerMax = 0;
        int checkerMin = 0;
        boolean forward = true;

        for (int i = 0; i < len_N; i++) {
            if (forward == false) break;
            if (checkerMax == len_D) break;
            if (checkerMin == len_D) break;

            forward = false;
            checkerMax = 0;
            checkerMin = 0;

            for (int j = 0; j < len_D; j++) {
                if (digits[j] - str_N.charAt(i) < 0) {
                    res += (int) Math.pow(len_D, len_N - 1 - i);
                    checkerMin = +1;
                    if (checkerMin == len_D) break;
                }

                if (digits[j] == str_N.charAt(i)) {
                    forward = true;
                }

                if (digits[j] - str_N.charAt(i) > 0) {
                    checkerMax += 1;
                    if (checkerMax == len_D) break;
                }
            }
        }

        res += base(len_D, len_N - 1);

        int equal = 0;

        for (int i = 0; i < len_N; i++) {
            for (int j = 0; j < len_D; j++) {
                if (digits[j] == str_N.charAt(i)) {
                    equal += 1;
                }
            }
        }

        if (equal == len_N) return res + 1;
        else return res;
    }

    private int base(int x, int y) {
        int ttl = 0;
        for (int i = y; i > 0; i--) {
            ttl += Math.pow(x, i);
        }
        return ttl;
    }
}
