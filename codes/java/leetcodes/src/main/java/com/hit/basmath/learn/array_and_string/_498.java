package com.hit.basmath.learn.array_and_string;

/**
 * 498. Diagonal Traverse
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * Note: The total number of elements of the given matrix will not exceed 10,000.
 */
public class _498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        // Initial variable
        int row = 0, col = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] aimArr = new int[m * n];

        // Execute m * n times circle, in order to fill m * n element into aimArr
        for (int i = 0; i < aimArr.length; i++) {
            aimArr[i] = matrix[row][col];
            /**
             * According to this subject model, we can find some rules about index of matrix.
             * For example, the sum of all moving up trajectory element can be divided by 2，
             * and the sum of all moving down trajectory element can't be divided by 2
             */
            if ((row + col) % 2 == 0) {
                // moving up
                if (col == n - 1) {
                    /**
                     * If col == n - 1, it's mean this position is last column,
                     * so, only row index must be increased
                     */
                    row++;
                } else if (row == 0) {
                    /**
                     * If row == 0, it's mean this position is first row,
                     * so, only column index can be increased
                     */
                    col++;
                } else {
                    /**
                     * In this condition, in order to moving up,
                     * column index must be increased and row index must be decreased
                     */
                    row--;
                    col++;
                }
            } else {
                // moving down
                if (row == m - 1) {
                    /**
                     * If row == m - 1, it's mean this position is last row,
                     * so, only column index must be increased
                     */
                    col++;
                } else if (col == 0) {
                    /**
                     * If col == 0, it's mean this position is first column,
                     * so, only row index can be increased
                     */
                    row++;
                } else {
                    /**
                     * In this condition, in order to moving down,
                     * row index must be increased and column index must be decreased
                     */
                    row++;
                    col--;
                }
            }
        }
        return aimArr;
    }
}
