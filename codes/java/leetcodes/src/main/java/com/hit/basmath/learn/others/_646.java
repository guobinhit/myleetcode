package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 646. Maximum Length of Pair Chain
 * <p>
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * <p>
 * Explanation: The longest chain is [1,2] -> [3,4]
 * <p>
 * Note: The number of given pairs will be in the range [1, 1000].
 */
public class _646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int sum = 0, n = pairs.length, i = -1;
        while (++i < n) {
            sum++;
            int curEnd = pairs[i][1];
            while (i + 1 < n && pairs[i + 1][0] <= curEnd) i++;
        }
        return sum;
    }
}
