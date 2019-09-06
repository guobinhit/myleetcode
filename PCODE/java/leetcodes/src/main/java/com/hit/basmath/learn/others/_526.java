package com.hit.basmath.learn.others;

/**
 * 526. Beautiful Arrangement
 * <p>
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
 * <p>
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * <p>
 * Now given N, how many beautiful arrangements can you construct?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * The first beautiful arrangement is [1, 2]:
 * <p>
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * <p>
 * The second beautiful arrangement is [2, 1]:
 * <p>
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * <p>
 * Note:
 * <p>
 * N is a positive integer and will not exceed 15.
 */
public class _526 {
    int count = 0;

    public int countArrangement(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }
}
