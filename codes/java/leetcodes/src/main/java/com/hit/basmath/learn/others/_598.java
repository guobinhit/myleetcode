package com.hit.basmath.learn.others;

/**
 * 598. Range Addition II
 * <p>
 * Given an m * n matrix M initialized with all 0's and several update operations.
 * <p>
 * Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
 * <p>
 * You need to count and return the number of maximum integers in the matrix after performing all the operations.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * <p>
 * Output: 4
 * <p>
 * Explanation:
 * Initially, M =
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * <p>
 * After performing [2,2], M =
 * [[1, 1, 0],
 * [1, 1, 0],
 * [0, 0, 0]]
 * <p>
 * After performing [3,3], M =
 * [[2, 2, 1],
 * [2, 2, 1],
 * [1, 1, 1]]
 * <p>
 * So the maximum integer in M is 2, and there are four of it in M. So return 4.
 * <p>
 * Note:
 * <p>
 * The range of m and n is [1,40000].
 * The range of a is [1,m], and the range of b is [1,n].
 * The range of operations size won't exceed 10,000.
 */
public class _598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }

        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
        for (int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }

        return row * col;
    }
}
