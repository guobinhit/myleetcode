package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 913. Cat and Mouse
 * <p>
 * A game on an undirected graph is played by two players, Mouse and Cat, who alternate turns.
 * <p>
 * The graph is given as follows: graph[a] is a list of all nodes b such that ab is an edge of the graph.
 * <p>
 * Mouse starts at node 1 and goes first, Cat starts at node 2 and goes second, and there is a Hole at node 0.
 * <p>
 * During each player's turn, they must travel along one edge of the graph that meets where they are.  For example, if the Mouse is at node 1, it must travel to any node in graph[1].
 * <p>
 * Additionally, it is not allowed for the Cat to travel to the Hole (node 0.)
 * <p>
 * Then, the game can end in 3 ways:
 * <p>
 * If ever the Cat occupies the same node as the Mouse, the Cat wins.
 * If ever the Mouse reaches the Hole, the Mouse wins.
 * If ever a position is repeated (ie. the players are in the same position as a previous turn, and it is the same player's turn to move), the game is a draw.
 * Given a graph, and assuming both players play optimally, return 1 if the game is won by Mouse, 2 if the game is won by Cat, and 0 if the game is a draw.
 * <p>
 * Example 1:
 * <p>
 * Input: [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * Output: 0
 * Explanation:
 * 4---3---1
 * |   |
 * 2---5
 * \ /
 * 0
 * <p>
 * Note:
 * <p>
 * 3 <= graph.length <= 50
 * It is guaranteed that graph[1] is non-empty.
 * It is guaranteed that graph[2] contains a non-zero element.
 */
public class _913 {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] f = new int[n + n][n][n];
        fill(f, -1);

        return find(graph, f, 0, 1, 2);
    }

    private int find(int[][] graph, int[][][] f, int t, int x /* mouse */, int y /* cat */) {
        if (t == graph.length * 2) return 0; // draw
        if (x == 0) return 1; // mouse wins
        if (x == y) return 2; // cat wins
        if (f[t][x][y] != -1) return f[t][x][y];

        if (t % 2 == 0) {
            // mouse moves
            // for the next position that mouse gonna move to,
            // if all possibilities lead to cat-win, then it is
            // surely the cat will win.
            // otherwise, if any 1 possibility leads to mouse-win,
            // the mouse should move to that position and then the
            // mouse will win.
            // otherwise, it is a draw.
            boolean cat_win = true;
            for (int next : graph[x]) {
                int r = find(graph, f, t + 1, next, y);
                if (r == 1) {
                    return f[t][x][y] = 1;
                }
                if (r == 0) {
                    cat_win = false;
                }
            }
            if (cat_win) return f[t][x][y] = 2;
            else return f[t][x][y] = 0;
        } else {
            // cat moves
            // the analysis is similar as above.
            boolean mouse_win = true;
            for (int next : graph[y]) {
                if (next == 0) continue; // cat cannot go to hole
                int r = find(graph, f, t + 1, x, next);
                if (r == 2) {
                    return f[t][x][y] = 2;
                }
                if (r == 0) {
                    mouse_win = false;
                }
            }
            if (mouse_win) return f[t][x][y] = 1;
            else return f[t][x][y] = 0;
        }
    }

    private void fill(int[][][] f, int val) {
        for (int[][] ints : f) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, val);
            }
        }
    }
}
