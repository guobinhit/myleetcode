package com.hit.basmath.learn.queue_stack;

/**
 * 200. Number of Islands
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class _200 {
    private static int gridLenght;
    private static int gridDepth;

    public static int numIslands(char[][] grid) {
        /**
         * Record island number
         */
        int count = 0;
        gridLenght = grid.length;
        if (gridLenght == 0) {
            return 0;
        }
        gridDepth = grid[0].length;
        for (int i = 0; i < gridLenght; i++) {
            for (int j = 0; j < gridDepth; j++)
                if (grid[i][j] == '1') {
                    dfsMark(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private static void dfsMark(char[][] grid, int i, int j) {
        /**
         * When we are meet 4 edges of grid, return immediately
         */
        if (i < 0 || j < 0 || i >= gridLenght || j >= gridDepth || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        /**
         * This 4 iteration is handle current element's 4 edges
         */
        dfsMark(grid, i + 1, j);
        dfsMark(grid, i - 1, j);
        dfsMark(grid, i, j + 1);
        dfsMark(grid, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] test1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] test2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("In this grid, island's number is " + _200.numIslands(test1));
        System.out.println("In this grid, island's number is " + _200.numIslands(test2));
    }
}
