package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 749. Contain Virus
 * <p>
 * A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.
 * <p>
 * The world is modeled as a 2-D array of cells, where 0 represents uninfected cells, and 1 represents cells contaminated with the virus. A wall (and only one wall) can be installed between any two 4-directionally adjacent cells, on the shared boundary.
 * <p>
 * Every night, the virus spreads to all neighboring cells in all four directions unless blocked by a wall. Resources are limited. Each day, you can install walls around only one region -- the affected area (continuous block of infected cells) that threatens the most uninfected cells the following night. There will never be a tie.
 * <p>
 * Can you save the day? If so, what is the number of walls required? If not, and the world becomes fully infected, return the number of walls used.
 * <p>
 * Example 1:
 * <p>
 * Input: grid =
 * [[0,1,0,0,0,0,0,1],
 * [0,1,0,0,0,0,0,1],
 * [0,0,0,0,0,0,0,1],
 * [0,0,0,0,0,0,0,0]]
 * Output: 10
 * Explanation:
 * There are 2 contaminated regions.
 * On the first day, add 5 walls to quarantine the viral region on the left. The board after the virus spreads is:
 * <p>
 * [[0,1,0,0,0,0,1,1],
 * [0,1,0,0,0,0,1,1],
 * [0,0,0,0,0,0,1,1],
 * [0,0,0,0,0,0,0,1]]
 * <p>
 * On the second day, add 5 walls to quarantine the viral region on the right. The virus is fully contained.
 * <p>
 * Example 2:
 * <p>
 * Input: grid =
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output: 4
 * Explanation: Even though there is only one cell saved, there are 4 walls built.
 * Notice that walls are only built on the shared boundary of two different cells.
 * <p>
 * Example 3:
 * <p>
 * Input: grid =
 * [[1,1,1,0,0,0,0,0,0],
 * [1,0,1,0,1,1,1,1,1],
 * [1,1,1,0,0,0,0,0,0]]
 * Output: 13
 * Explanation: The region on the left only builds two new walls.
 * <p>
 * Note:
 * <p>
 * 1. The number of rows and columns of grid will each be in the range [1, 50].
 * 2. Each grid[i][j] will be either 0 or 1.
 * 3. Throughout the described process, there is always a contiguous viral region that will infect strictly more uncontaminated squares in the next round.
 */
public class _749 {
    public int containVirus(int[][] grid) {
        int[] cost = new int[]{0};
        while (check(grid, cost)) ;
        return cost[0];
    }

    private boolean check(int[][] grid, int[] cost) {
        // update every day information and return false if no improvement can be made
        int count = 1;
        int max = -1;
        boolean flag = false;
        List<int[]> info = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    int[][] walls = new int[grid.length][grid[0].length];
                    int[] res = new int[2];
                    grid[i][j] = count;
                    dfs(i, j, grid, count, walls, res);
                    if (res[0] != 0) flag = true;
                    if (max == -1 || res[0] > info.get(max)[0]) {
                        max = count - 2;
                    }
                    info.add(res);
                }
            }
        }
        if (count == 1) {
            return false;
        }
        cost[0] += info.get(max)[1];
        update(grid, max + 2);
        return flag;
    }


    private void dfs(int row, int col, int[][] grid, int count, int[][] walls, int[] res) {
        //dfs and record number of walls need to block this area and how many 0s are under infection
        int[] shiftX = new int[]{1, 0, -1, 0};
        int[] shiftY = new int[]{0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + shiftX[i];
            int newCol = col + shiftY[i];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                if (grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = count;
                    dfs(newRow, newCol, grid, count, walls, res);
                } else if (grid[newRow][newCol] == 0) {
                    if (walls[newRow][newCol] == 0) res[0]++;
                    if ((walls[newRow][newCol] & 1 << i) == 0) {
                        res[1]++;
                        walls[newRow][newCol] |= 1 << i;
                    }
                }
            }
        }
    }


    private void update(int[][] grid, int quarantine) {
        //set the new infected area and set blocked area to be -1
        int[] shiftX = new int[]{1, 0, -1, 0};
        int[] shiftY = new int[]{0, 1, 0, -1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1 && grid[i][j] != quarantine) {
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + shiftX[k];
                        int newCol = j + shiftY[k];
                        if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 0) {
                            grid[newRow][newCol] = 1;
                        }
                    }
                    grid[i][j] = 1;
                } else if (grid[i][j] == quarantine) {
                    grid[i][j] = -1;
                }
            }
        }
    }
}
