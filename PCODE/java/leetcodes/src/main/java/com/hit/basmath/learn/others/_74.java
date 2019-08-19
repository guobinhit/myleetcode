package com.hit.basmath.learn.others;

/**
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * <p>
 * target = 3
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * <p>
 * target = 13
 * Output: false
 */
public class _74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int l = 0;
        int r = n * m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int i = mid / m, j = mid % m;
            if (matrix[i][j] == target) {
                return true;
            }
            if (l == r) break;
            if (matrix[i][j] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }
}
