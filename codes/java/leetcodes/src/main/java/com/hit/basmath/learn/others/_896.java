package com.hit.basmath.learn.others;

/**
 * 896. Monotonic Array
 * <p>
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: [6,5,4,4]
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: [1,3,2]
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: [1,2,4,5]
 * Output: true
 * <p>
 * Example 5:
 * <p>
 * Input: [1,1,1]
 * Output: true
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class _896 {
    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }
}
