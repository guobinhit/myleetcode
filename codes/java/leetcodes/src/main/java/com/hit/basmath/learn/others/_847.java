package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 847. Shortest Path Visiting All Nodes
 * <p>
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 * <p>
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 * <p>
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * <p>
 * Example 2:
 * <p>
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 * <p>
 * Note:
 * <p>
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 */
public class _847 {
    public int shortestPathLength(int[][] graph) {
        int[][] dp = new int[graph.length][1 << graph.length];
        Queue<State> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
            queue.offer(new State(1 << i, i));
        }

        while (!queue.isEmpty()) {
            State state = queue.poll();

            for (int next : graph[state.source]) {
                int nextMask = state.mask | 1 << next;
                if (dp[next][nextMask] > dp[state.source][state.mask] + 1) {
                    dp[next][nextMask] = dp[state.source][state.mask] + 1;
                    queue.offer(new State(nextMask, next));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            res = Math.min(res, dp[i][(1 << graph.length) - 1]);
        }
        return res;
    }

    class State {
        public int mask, source;

        public State(int m, int s) {
            mask = m;
            source = s;
        }
    }
}
