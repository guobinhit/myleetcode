package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 827. Making A Large Island
 * <p>
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 * <p>
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 * <p>
 * Example 1:
 * <p>
 * Input: [[1, 0], [0, 1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * <p>
 * Example 2:
 * <p>
 * Input: [[1, 1], [1, 0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * <p>
 * Example 3:
 * <p>
 * Input: [[1, 1], [1, 1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 * <p>
 * Notes:
 * <p>
 * 1 <= grid.length = grid[0].length <= 50.
 * 0 <= grid[i][j] <= 1.
 */
public class _827 {
    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // create father array and size array, and initialize them
        int[] father = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            father[i] = i;
        }
        int[] size = new int[rows * cols];
        Arrays.fill(size, 1);

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        // scan grid, update father array and size array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int id = i * cols + j;
                    for (int k = 0; k < 4; k++) {
                        int newi = i + dx[k];
                        int newj = j + dy[k];
                        int newid = newi * cols + newj;
                        if (isValid(rows, cols, newi, newj) && grid[newi][newj] == 1) {
                            union(father, size, id, newid);
                        }
                    }
                }
            }
        }

        // find current max component size
        int max = 0;
        for (int i = 0; i < size.length; i++) {
            max = Math.max(max, size[i]);
        }

        // find max component size if we set any 0 to 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    int id = i * cols + j;
                    int combinedSize = 1;
                    Set<Integer> prevFather = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int newi = i + dx[k];
                        int newj = j + dy[k];
                        int newid = newi * cols + newj;
                        if (isValid(rows, cols, newi, newj) && grid[newi][newj] == 1) {
                            int currFather = find(father, newid);
                            if (prevFather.isEmpty() || !prevFather.contains(currFather)) {
                                combinedSize += size[currFather];
                                prevFather.add(currFather);
                            }
                        }
                    }
                    max = Math.max(max, combinedSize);
                }
            }
        }

        // return whole size if the grid is an all 1 matrix, otherwise return the value of max
        return max == 0 ? rows * cols : max;
    }

    private int find(int[] father, int id) {
        if (father[id] == id) {
            return id;
        }
        return father[id] = find(father, father[id]);
    }

    private void union(int[] father, int[] size, int id1, int id2) {
        int fa1 = find(father, id1);
        int fa2 = find(father, id2);
        if (fa1 != fa2) {
            father[fa1] = fa2;
            size[fa2] += size[fa1];
        }
    }

    private boolean isValid(int rows, int cols, int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            return true;
        }
        return false;
    }
}
