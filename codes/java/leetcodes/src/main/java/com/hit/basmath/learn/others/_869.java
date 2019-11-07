package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 869. Reordered Power of 2
 * <p>
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: 10
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: 16
 * Output: true
 * <p>
 * Example 4:
 * <p>
 * Input: 24
 * Output: false
 * <p>
 * Example 5:
 * <p>
 * Input: 46
 * Output: true
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 */
public class _869 {
    public boolean reorderedPowerOf2(int N) {
        char[] a1 = String.valueOf(N).toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);

        for (int i = 0; i < 31; i++) {
            char[] a2 = String.valueOf((int) (1 << i)).toCharArray();
            Arrays.sort(a2);
            String s2 = new String(a2);
            if (s1.equals(s2)) return true;
        }

        return false;
    }
}
