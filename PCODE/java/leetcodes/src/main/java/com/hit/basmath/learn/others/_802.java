package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 802. Find Eventual Safe States
 * <p>
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
 * <p>
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
 * <p>
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 * <p>
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 * <p>
 * Example:
 * <p>
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * <p>
 * Note:
 * <p>
 * graph will have length at most 10000.
 * The number of edges in the graph will not exceed 32000.
 * Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */
public class _802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) return res;

        int nodeCount = graph.length;
        int[] color = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            if (dfs(graph, i, color)) res.add(i);
        }

        return res;
    }

    private boolean dfs(int[][] graph, int start, int[] color) {
        if (color[start] != 0) return color[start] == 1;

        color[start] = 2;
        for (int newNode : graph[start]) {
            if (!dfs(graph, newNode, color)) return false;
        }
        color[start] = 1;

        return true;
    }
}
