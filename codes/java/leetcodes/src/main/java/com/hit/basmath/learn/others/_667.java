package com.hit.basmath.learn.others;

/**
 * 667. Beautiful Arrangement II
 * <p>
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * <p>
 * If there are multiple answers, print any of them.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3, k = 1
 * Output: [1, 2, 3]
 * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3, k = 2
 * Output: [1, 3, 2]
 * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
 * <p>
 * Note: The n and k are in the range 1 <= k < n <= 10^4.
 */
public class _667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        return res;
    }
}
