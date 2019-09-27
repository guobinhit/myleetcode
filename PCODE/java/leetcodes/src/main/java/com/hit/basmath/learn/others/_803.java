package com.hit.basmath.learn.others;

/**
 * 803. Bricks Falling When Hit
 * <p>
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.
 * <p>
 * We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.
 * <p>
 * Return an array representing the number of bricks that will drop after each erasure in sequence.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * Output: [2]
 * Explanation:
 * If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * Output: [0,0]
 * Explanation:
 * When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.
 * <p>
 * Note:
 * <p>
 * The number of rows and columns in the grid will be in the range [1, 200].
 * The number of erasures will not exceed the area of the grid.
 * It is guaranteed that each erasure will be different from any other erasure, and located inside the grid.
 * An erasure may refer to a location with no brick - if it does, no bricks drop.
 */
public class _803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        if (hits == null || hits.length == 0) return null;
        int[] res = new int[hits.length];
        if (grid == null || grid.length == 0) return res;
        int m = grid.length, n = grid[0].length;
        if (n == 0) return res;

        for (int k = 0; k < hits.length; k++) {
            int x = hits[k][0], y = hits[k][1];
            if (grid[x][y] == 1) grid[x][y] = -1;
        }
        // set all cells attached to the roof to 2
        int count = countBricks(grid);

        for (int k = hits.length - 1; k >= 0; k--) {
            int x = hits[k][0], y = hits[k][1];
            if (grid[x][y] == 0) res[k] = 0;
            else {
                grid[x][y] = 1;
                if (!attachedToRoof(grid, x, y)) continue;
                res[k] = dfs(grid, x, y) - 1;
            }
        }
        return res;
    }

    private int countBricks(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int j = 0; j < n; j++) {
            count += dfs(grid, 0, j);
        }
        return count;
    }

    // count all cells starting from (i, j)
    private int dfs(int[][] grid, int i, int j) {
        if (grid[i][j] != 1) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 1;
        grid[i][j] = 2;
        int[] shift = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int p = i + shift[k];
            int q = j + shift[k + 1];
            if (p < 0 || p >= m || q < 0 || q >= n) continue;
            if (grid[p][q] != 1) continue;
            count += dfs(grid, p, q);
        }
        return count;
    }

    private boolean attachedToRoof(int[][] grid, int i, int j) {
        if (i == 0) return true;
        int m = grid.length, n = grid[0].length;
        int[] shift = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int p = i + shift[k];
            int q = j + shift[k + 1];
            if (p < 0 || p >= m || q < 0 || q >= n) continue;
            if (grid[p][q] == 2) return true;
        }
        return false;
    }
}
