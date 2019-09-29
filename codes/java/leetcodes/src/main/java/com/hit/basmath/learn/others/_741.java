package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 741. Cherry Pickup
 * <p>
 * In a N x N grid representing a field of cherries, each cell is one of three possible integers.
 * <p>
 * 0 means the cell is empty, so you can pass through;
 * 1 means the cell contains a cherry, that you can pick up and pass through;
 * -1 means the cell contains a thorn that blocks your way.
 * <p>
 * Your task is to collect maximum number of cherries possible by following the rules below:
 * <p>
 * Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
 * After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
 * When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
 * If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
 * <p>
 * Example 1:
 * <p>
 * Input: grid =
 * [[0, 1, -1],
 * [1, 0, -1],
 * [1, 1,  1]]
 * Output: 5
 * Explanation:
 * The player started at (0, 0) and went down, down, right right to reach (2, 2).
 * 4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
 * Then, the player went left, up, up, left to return home, picking up one more cherry.
 * The total number of cherries picked up is 5, and this is the maximum possible.
 * <p>
 * Note:
 * <p>
 * grid is an N by N 2D array, with 1 <= N <= 50.
 * Each grid[i][j] is an integer in the set {-1, 0, 1}.
 * It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1.
 */
public class _741 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[1][1][1] = grid[0][0];
        for (int x1 = 1; x1 <= n; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                for (int x2 = 1; x2 <= n; x2++) {
                    int y2 = x1 + y1 - x2;
                    if (dp[x1][y1][x2] > 0 || y2 < 1 || y2 > n || grid[x1 - 1][y1 - 1] == -1 || grid[x2 - 1][y2 - 1] == -1) {
                        continue;
                        // have already detected || out of boundary || cannot access
                    }
                    int cur = Math.max(Math.max(dp[x1 - 1][y1][x2], dp[x1 - 1][y1][x2 - 1]), Math.max(dp[x1][y1 - 1][x2], dp[x1][y1 - 1][x2 - 1]));
                    if (cur < 0) {
                        continue;
                    }
                    dp[x1][y1][x2] = cur + grid[x1 - 1][y1 - 1];
                    if (x1 != x2) {
                        dp[x1][y1][x2] += grid[x2 - 1][y2 - 1];
                    }
                }
            }
        }
        return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
    }
}
