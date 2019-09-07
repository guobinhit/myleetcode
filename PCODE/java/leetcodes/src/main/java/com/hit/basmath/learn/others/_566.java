package com.hit.basmath.learn.others;

/**
 * 566. Reshape the Matrix
 * <p>
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * <p>
 * Output:
 * [[1,2,3,4]]
 * <p>
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * <p>
 * Output:
 * [[1,2],
 * [3,4]]
 * <p>
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * <p>
 * Note:
 * <p>
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 */
public class _566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r * c != n * m) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++)
            res[i / c][i % c] = nums[i / m][i % m];
        return res;
    }
}
