package com.hit.basmath.learn.others;

/**
 * 867. Transpose Matrix
 * <p>
 * Given a matrix A, return the transpose of A.
 * <p>
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */
public class _867 {
    public int[][] transpose(int[][] A) {
        int b1 = A[0].length;
        int b2 = A.length;
        int[][] B = new int[b1][b2];
        for (int i = 0; i < b1; i++) {
            for (int j = 0; j < b2; j++) {
                B[i][j] = A[j][i];
            }
        }
        return B;
    }
}
