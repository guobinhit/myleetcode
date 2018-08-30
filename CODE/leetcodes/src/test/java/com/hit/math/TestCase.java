package com.hit.math;

import com.hit.math.utils.CommonUtils;

import java.math.BigInteger;
import java.util.*;

/**
 * author:Charies Gavin
 * date:2018/8/25,17:00
 * https:github.com/guobinhit
 * description: Test Case Class
 */
public class TestCase {
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
        System.out.println("In this grid, island's number is " + TestCase.numIslands(test1));
        System.out.println("In this grid, island's number is " + TestCase.numIslands(test2));
    }
}
