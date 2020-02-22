package com.hit.basmath.learn.others;

/**
 * 59. Spiral Matrix II
 * <p>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * <p>
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class _59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, top = 0;
        int right = n - 1, down = n - 1;
        int count = 1;
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = count++;
            }
            top++;
            for (int j = top; j <= down; j++) {
                ans[j][right] = count++;
            }
            right--;
            for (int k = right; k >= left; k--) {
                ans[down][k] = count++;
            }
            down--;
            for (int m = down; m >= top; m--) {
                ans[m][left] = count++;
            }
            left++;
        }
        return ans;
    }
}
