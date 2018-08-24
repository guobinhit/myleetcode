package com.hit.math.array_string;

import com.hit.math.utils.CommonUtils;

/**
 * 498. Diagonal Traverse
 * <p>
 * Given a matrix of m x N elements (m rows, N columns), return all elements of the matrix in diagonal order
 * as shown in the below image.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * Note:
 * <p>
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class _498 {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        /**
         * Initial variable
         */
        int row = 0, col = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] aimArr = new int[m * n];
        /**
         * Execute m * n times circle, in order to fill m * n element into aimArr
         */
        for (int i = 0; i < aimArr.length; i++) {
            aimArr[i] = matrix[row][col];
            /**
             * According to this subject model, we can find some rules about index of matrix.
             * For example, the sum of all moving up trajectory element can be divided by 2，
             * and the sum of all moving down trajectory element can't be divided by 2
             */
            if ((row + col) % 2 == 0) { // moving up
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else { // moving down
                if (row == m - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return aimArr;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4},
                {4, 5, 6,7},
                {7, 8, 9,10}};
        CommonUtils.printIntArray(_498.findDiagonalOrder(matrix));
    }
}
