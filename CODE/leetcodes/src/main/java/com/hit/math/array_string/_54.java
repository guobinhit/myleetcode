package com.hit.math.array_string;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example,
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class _54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        // If matrix.length == 0, return res immediately
        if (matrix.length == 0) {
            return res;
        }

        // Initial variables
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        /**
         * Iterate all element of matrix，condition is rowBegin <= rowEnd && colBegin <= colEnd
         */
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            /**
             * When first circle finished, it's mean first row has handled over,
             * so rowBegin++, and the next cycle is similar.
             */
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            /**
             * When this circle finished, it's mean last column has handled over,
             * so colEnd--, and the next cycle is similar.
             */
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            /**
             * When this circle finished, it's mean last row has handled over,
             * so rowEnd--, and the next cycle is similar.
             */
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            /**
             * When this circle finished, it's mean first row has handled over,
             * so colBegin++, and the next cycle is similar.
             */
            colBegin++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {4, 5, 6, 7},
                {7, 8, 9, 10},
                {11, 12, 13, 14}};
        System.out.println(_54.spiralOrder(matrix));
    }
}
