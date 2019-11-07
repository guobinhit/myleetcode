package com.hit.basmath.learn.others;

/**
 * 861. Score After Flipping Matrix
 * <p>
 * We have a two dimensional matrix A where each value is 0 or 1.
 * <p>
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
 * <p>
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
 * <p>
 * Return the highest possible score.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * Output: 39
 * Explanation:
 * Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] is 0 or 1.
 */
public class _861 {
    public int matrixScore(int[][] A) {
        int N = A.length,
                M = A[0].length;

        // Optimize, step1: flip all rows starting with a zero
        for (int i = 0; i < N; ++i) {
            if (A[i][0] == 0)
                flipRow(A, i);
        }

        // Optimize, step 2: flip all columns where the number of zeros is larger than the number of ones
        for (int col = 1; col < M; ++col) {
            int sumCol = 0;
            for (int i = 0; i < N; ++i)
                sumCol += A[i][col];

            if (sumCol * 2 < N)
                flipCol(A, col);
        }

        // Count final sum
        int total = 0;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                total += A[i][j] * (1 << (M - j - 1));

        return total;
    }

    private void flipRow(int[][] a, int r) {
        for (int i = 0; i < a[r].length; ++i)
            a[r][i] = (a[r][i] ^ 1);
    }

    private void flipCol(int[][] a, int c) {
        for (int i = 0; i < a.length; ++i)
            a[i][c] = (a[i][c] ^ 1);
    }
}
