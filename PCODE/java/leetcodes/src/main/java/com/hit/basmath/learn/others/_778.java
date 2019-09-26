package com.hit.basmath.learn.others;

/**
 * 778. Swim in Rising Water
 * <p>
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 * <p>
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 * <p>
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * <p>
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * <p>
 * Example 2:
 * <p>
 * Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 * 0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * <p>
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 * <p>
 * Note:
 * <p>
 * 1. 2 <= N <= 50.
 * 2. grid[i][j] is a permutation of [0, ..., N*N - 1].
 */
public class _778 {
    private int[][] moves = {
            {-1, 0}, // move left
            {0, 1}, // move down
            {1, 0}, // move right
            {0, -1}}; // move up

    public int swimInWater(int[][] spots) {
        int len = spots.length;
        int lo = spots[0][0];
        int hi = len * len - 1;
        while (lo <= hi) {
            int guessTime = lo + ((hi - lo) >> 1);
            boolean[][] visited = new boolean[len][len];
            boolean canReachEnd = hasPath(guessTime, 0, 0, spots, visited);
            if (canReachEnd) {
                // if we can reach to the end under guesstime,
                // then we check if there is a faster path
                hi = guessTime - 1;
            } else {
                // if there is no path to the end under guesstime,
                // we increment the guesstime till we actually find one
                lo = guessTime + 1;
            }
        }
        return lo;
    }


    private boolean hasPath(int curTime, int x, int y, int[][] spots, boolean[][] visited) {
        visited[x][y] = true;
        int len = visited.length;
        if (x == len - 1 && y == len - 1) {
            // already arrived the destination, which means we have a possible path within the guesstime
            return true;
        }
        // now check if it can move left, right, up, or down.
        for (int i = 0; i < 4; i++) {
            int nextX = x + moves[i][0], nextY = y + moves[i][1];
            if (nextX < 0 || nextX >= len || nextY < 0 || nextY >= len
                    || visited[nextX][nextY] || spots[nextX][nextY] > curTime) {
                // if the current next possible move won't work, check another next possible move
                continue;
            }
            // if current move works, then check the next possible path
            if (hasPath(curTime, nextX, nextY, spots, visited)) {
                return true;
            }
        }
        return false;
    }
}
