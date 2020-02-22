package com.hit.basmath.learn.array_and_string;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example, given the following matrix:
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
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> targetList = new ArrayList<Integer>();

        // If matrix.length == 0, return targetList immediately
        if (matrix.length == 0) return targetList;

        // Initial variables
        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        // Iterate all element of matrix，condition is rowBegin <= rowEnd && colBegin <= colEnd
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int i = colBegin; i <= colEnd; i++) {
                targetList.add(matrix[rowBegin][i]);
            }

            /**
             * When first circle finished, it's mean first row has handled over,
             * so rowBegin++, and the next cycle is similar.
             */
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                targetList.add(matrix[j][colEnd]);
            }

            /**
             * When this circle finished, it's mean last column has handled over,
             * so colEnd--, and the next cycle is similar.
             */
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int k = colEnd; k >= colBegin; k--) {
                    targetList.add(matrix[rowEnd][k]);
                }
            }

            /**
             * When this circle finished, it's mean last row has handled over,
             * so rowEnd--, and the next cycle is similar.
             */
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int m = rowEnd; m >= rowBegin; m--) {
                    targetList.add(matrix[m][colBegin]);
                }
            }

            /**
             * When this circle finished, it's mean first row has handled over,
             * so colBegin++, and the next cycle is similar.
             */
            colBegin++;
        }
        return targetList;
    }
}
