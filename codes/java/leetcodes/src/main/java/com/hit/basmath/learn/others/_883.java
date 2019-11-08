package com.hit.basmath.learn.others;

/**
 * 883. Projection Area of 3D Shapes
 * <p>
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * <p>
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
 * <p>
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 * <p>
 * Return the total area of all three projections.
 * <p>
 * Example 1:
 * <p>
 * Input: [[2]]
 * Output: 5
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,2],[3,4]]
 * Output: 17
 * Explanation:
 * Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
 * <p>
 * Example 3:
 * <p>
 * Input: [[1,0],[0,2]]
 * Output: 8
 * <p>
 * Example 4:
 * <p>
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 14
 * <p>
 * Example 5:
 * <p>
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 21
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 50
 */
public class _883 {
    public int projectionArea(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 0; j < n; ++j) {
                x = Math.max(x, grid[i][j]);
                y = Math.max(y, grid[j][i]);
                if (grid[i][j] > 0) ++res;
            }
            res += x + y;
        }
        return res;
    }
}
