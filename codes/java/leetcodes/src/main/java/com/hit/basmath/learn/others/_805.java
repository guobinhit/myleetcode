package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 805. Split Array With Same Average
 * <p>
 * In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)
 * <p>
 * Return true if and only if after such a move, it is possible that the average value of B is equal to the average value of C, and B and C are both non-empty.
 * <p>
 * Example :
 * <p>
 * Input:
 * [1,2,3,4,5,6,7,8]
 * Output: true
 * Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
 * <p>
 * Note:
 * <p>
 * The length of A will be in the range [1, 30].
 * A[i] will be in the range of [0, 10000].
 */
public class _805 {
    private boolean check(int[] A, int leftSum, int leftNum, int startIndex) {
        if (leftNum == 0) return leftSum == 0;
        if ((A[startIndex]) > leftSum / leftNum) return false;
        for (int i = startIndex; i < A.length - leftNum + 1; i++) {
            if (i > startIndex && A[i] == A[i - 1]) continue;
            if (check(A, leftSum - A[i], leftNum - 1, i + 1)) return true;
        }
        return false;
    }

    public boolean splitArraySameAverage(int[] A) {
        if (A.length == 1) return false;
        int sumA = 0;
        for (int a : A) sumA += a;
        Arrays.sort(A);
        for (int lenOfB = 1; lenOfB <= A.length / 2; lenOfB++) {
            if ((sumA * lenOfB) % A.length == 0) {
                if (check(A, (sumA * lenOfB) / A.length, lenOfB, 0)) return true;
            }
        }
        return false;

    }
}
