package com.hit.basmath.learn.others;

import java.util.Stack;

/**
 * 907. Sum of Subarray Minimums
 * <p>
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 * <p>
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 */
public class _907 {
    public int sumSubarrayMins(int[] A) {
        int res = 0, n = A.length, mod = (int) 1e9 + 7;
        int[] left = new int[n], right = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > A[i])
                count += s1.pop()[1];
            s1.push(new int[]{A[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= A[i])
                count += s2.pop()[1];
            s2.push(new int[]{A[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + A[i] * left[i] * right[i]) % mod;
        return res;
    }
}
