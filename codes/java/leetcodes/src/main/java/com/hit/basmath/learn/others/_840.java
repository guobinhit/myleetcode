package com.hit.basmath.learn.others;

/**
 * 840. Magic Squares In Grid
 * <p>
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * <p>
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 * <p>
 * Example 1:
 * <p>
 * Input: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * Output: 1
 * Explanation:
 * <p>
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * <p>
 * while this one is not:
 * 384
 * 519
 * 762
 * <p>
 * In total, there is only one magic square inside the given grid.
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */
public class _840 {
    public int numMagicSquaresInside(int[][] grid) {
        //Assuming each row have the same length
        if (grid.length < 3 || grid[0].length < 3) return 0;

        int magicBoxCount = 0;
        for (int i = 0; i <= (grid.length - 3); i++) {
            for (int j = 0; (j <= grid[0].length - 3); j++) {
                if (isAMagicBox(grid, i, j))
                    magicBoxCount++;
            }
        }

        return magicBoxCount;
    }

    private boolean isAMagicBox(int[][] grid, int x, int y) {
        if (grid[x + 1][y + 1] != 5) return false;

        //corner are even
        if (grid[x][y] % 2 != 0 || grid[x + 2][y] % 2 != 0 ||
                grid[x][y + 2] % 2 != 0 || grid[x + 2][y + 2] % 2 != 0) {
            return false;
        }

        //not-corner are odd
        if (grid[x + 1][y] % 2 == 0 || grid[x][y + 1] % 2 == 0 ||
                grid[x + 1][y + 2] % 2 == 0 || grid[x + 2][y + 1] % 2 == 0) {
            return false;
        }

        if ((grid[x][y] + grid[x][y + 1] + grid[x][y + 2]) != 15 ||  //row1
                (grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2]) != 15 ||  //row2
                (grid[x][y] + grid[x + 1][y] + grid[x + 2][y]) != 15) //column 1
        {
            return false;
        }

        return true;
    }
}
