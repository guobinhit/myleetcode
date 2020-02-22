package com.hit.basmath.learn.recursion_ii;

/**
 * 240. Search a 2D Matrix II
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * 1. Integers in each row are sorted in ascending from left to right.
 * 2. Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * Example:
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class _240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (aMatrix[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int low = start;
        int high = vertical ? matrix[0].length - 1 : matrix.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    low = mid + 1;
                } else if (matrix[start][mid] > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    low = mid + 1;
                } else if (matrix[mid][start] > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
