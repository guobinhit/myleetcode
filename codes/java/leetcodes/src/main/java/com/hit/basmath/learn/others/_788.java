package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 788. Rotated Digits
 * <p>
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 * <p>
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 * <p>
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * <p>
 * Note:
 * <p>
 * N  will be in range [1, 10000].
 */
public class _788 {
    public int rotatedDigits(int N) {
        int[] rotate = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
        List<Integer> ds = new ArrayList();
        while (N > 0) {
            ds.add(N % 10);
            N /= 10;
        }
        int count = 0;
        boolean diff = false;
        for (int i = ds.size() - 1; i > -1; --i) {
            int good = 0, soso = 0, d = ds.get(i);
            for (int j = 0; j < d; ++j) {
                if (rotate[j] == 1) ++good;
                else if (rotate[j] == 0) ++soso;
            }
            count += (good + soso) * Math.pow(7, i);
            if (!diff) count -= soso * Math.pow(3, i);
            if (rotate[d] == -1) return count;
            if (rotate[d] == 1) diff = true;
        }
        return diff && rotate[ds.get(0)] > -1 ? count + 1 : count;
    }
}
