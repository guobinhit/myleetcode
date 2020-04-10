package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 882. Reachable Nodes In Subdivided Graph
 * <p>
 * Starting with an undirected graph (the "original graph") with nodes from 0 to N-1, subdivisions are made to some of the edges.
 * <p>
 * The graph is given as follows: edges[k] is a list of integer pairs (i, j, n) such that (i, j) is an edge of the original graph,
 * <p>
 * and n is the total number of new nodes on that edge.
 * <p>
 * Then, the edge (i, j) is deleted from the original graph, n new nodes (x_1, x_2, ..., x_n) are added to the original graph,
 * <p>
 * and n+1 new edges (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) are added to the original graph.
 * <p>
 * Now, you start at node 0 from the original graph, and in each move, you travel along one edge.
 * <p>
 * Return how many nodes you can reach in at most M moves.
 * <p>
 * Example 1:
 * <p>
 * Input: edges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3
 * Output: 13
 * Explanation:
 * The nodes that are reachable in the final graph after M = 6 moves are indicated below.
 * <p>
 * Example 2:
 * <p>
 * Input: edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4
 * Output: 23
 * <p>
 * Note:
 * <p>
 * 0 <= edges.length <= 10000
 * 0 <= edges[i][0] < edges[i][1] < N
 * There does not exist any i != j for which edges[i][0] == edges[j][0] and edges[i][1] == edges[j][1].
 * The original graph has no parallel edges.
 * 0 <= edges[i][2] <= 10000
 * 0 <= M <= 10^9
 * 1 <= N <= 3000
 * A reachable node is a node that can be travelled to using at most M moves starting from node 0.
 */
public class _882 {
    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        int result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        boolean[] visited = new boolean[N];
        pq.offer(new int[]{0, M});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int start = cur[0];
            int move = cur[1];
            if (visited[start]) {
                continue;
            }
            visited[start] = true;
            result++;
            for (int i = 0; i < N; i++) {
                if (graph[start][i] > -1) {
                    if (move > graph[start][i] && !visited[i]) {
                        pq.offer(new int[]{i, move - graph[start][i] - 1});
                    }
                    graph[i][start] -= Math.min(move, graph[start][i]);
                    result += Math.min(move, graph[start][i]);
                }
            }
        }
        return result;
    }
}
