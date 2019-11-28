package com.hit.basmath.learn.others;

/**
 * 892. Surface Area of 3D Shapes
 * <p>
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Return the total surface area of the resulting shapes.
 * <p>
 * Example 1:
 * <p>
 * Input: [[2]]
 * Output: 10
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,2],[3,4]]
 * Output: 34
 * <p>
 * Example 3:
 * <p>
 * Input: [[1,0],[0,2]]
 * Output: 16
 * <p>
 * Example 4:
 * <p>
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * <p>
 * Example 5:
 * <p>
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class _892 {
    public int surfaceArea(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) res += grid[i][j] * 4 + 2;
                if (i > 0) res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                if (j > 0) res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
            }
        }
        return res;
    }
}
