package com.hit.basmath.learn.others;

/**
 * 688. Knight Probability in Chessboard
 * <p>
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * <p>
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * <p>
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 * <p>
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
 * <p>
 * Example:
 * <p>
 * Input: 3, 2, 0, 0
 * Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 * <p>
 * Note:
 * <p>
 * N will be between 1 and 25.
 * K will be between 0 and 100.
 * The knight always initially starts on the board.
 */
public class _688 {
    private int[][] direction = new int[][]{{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][] prevWays = new double[N][N];
        prevWays[r][c] = 1;
        double res = 0;

        for (int k = 1; k <= K; ++k) {
            double[][] ways = new double[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    for (int[] dir : direction) {
                        int oldR = i - dir[0];
                        int oldC = j - dir[1];
                        if (oldR >= 0 && oldC >= 0 && oldR < N && oldC < N) {
                            ways[i][j] += (prevWays[oldR][oldC] / 8.0);
                        }
                    }
                }
            }
            prevWays = ways;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                res += prevWays[i][j];
            }
        }
        return res;
    }
}
