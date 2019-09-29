package com.hit.basmath.interview.top_interview_questions.hard_collection.trees_and_graphs;

/**
 * 329. Longest Increasing Path in a Matrix
 * <p>
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * Input: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * <p>
 * Output: 4
 * <p>
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * <p>
 * Example 2:
 * <p>
 * Input: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * <p>
 * Output: 4
 * <p>
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class _329 {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}
