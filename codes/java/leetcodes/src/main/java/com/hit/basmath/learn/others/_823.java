package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 823. Binary Trees With Factors
 * <p>
 * Given an array of unique integers, each integer is strictly greater than 1.
 * <p>
 * We make a binary tree using these integers and each number may be used for any number of times.
 * <p>
 * Each non-leaf node's value should be equal to the product of the values of it's children.
 * <p>
 * How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [2, 4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 * <p>
 * Example 2:
 * <p>
 * Input: A = [2, 4, 5, 10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 1000.
 * 2 <= A[i] <= 10 ^ 9.
 */
public class _823 {
    public int numFactoredBinaryTrees(int[] A) {
        long res = 0L, mod = (long) 1e9 + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            dp.put(A[i], 1L);
            for (int j = 0; j < i; ++j)
                if (A[i] % A[j] == 0)
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.getOrDefault(A[i] / A[j], 0L)) % mod);
            res = (res + dp.get(A[i])) % mod;
        }
        return (int) res;
    }
}
