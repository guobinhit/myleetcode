package com.hit.basmath.learn.others;

/**
 * 852. Peak Index in a Mountain Array
 * <p>
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 * <p>
 * Note:
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
public class _852 {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] < A[mid + 1]) { // peak index is after mid.
                lo = mid + 1;
            } else if (A[mid - 1] > A[mid]) { // peak index is before mid.
                hi = mid;
            } else { // peak index is mid.
                return mid;
            }
        }
        return -1; // no peak.
    }
}
