package com.hit.basmath.learn.others;

/**
 * 766. Toeplitz Matrix
 * <p>
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * <p>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,2,3,4],
 * [5,1,2,3],
 * [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,2],
 * [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * <p>
 * Note:
 * <p>
 * 1. matrix will be a 2D array of integers.
 * 2. matrix will have a number of rows and columns in range [1, 20].
 * 3. matrix[i][j] will be integers in range [0, 99].
 * <p>
 * Follow up:
 * <p>
 * 1. What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
 * 2. What if the matrix is so large that you can only load up a partial row into the memory at once?
 */
public class _766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        if (height <= 1 || width <= 1) return true;
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        return true;
    }
}
