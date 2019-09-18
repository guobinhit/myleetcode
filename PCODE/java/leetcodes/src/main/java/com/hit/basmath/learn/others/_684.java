package com.hit.basmath.learn.others;

/**
 * 684. Redundant Connection
 * <p>
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * <p>
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * <p>
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 * 1
 * / \
 * 2 - 3
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 * |   |
 * 4 - 3
 * <p>
 * Note:
 * <p>
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class _684 {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);

        for (int[] edge : edges) {
            if (!disjointSet.union(edge[0] - 1, edge[1] - 1)) return edge;
        }

        throw new IllegalArgumentException();
    }

    static class DisjointSet {

        private int[] parent;
        private byte[] rank;

        public DisjointSet(int n) {
            if (n < 0) throw new IllegalArgumentException();
            parent = new int[n];
            rank = new byte[n];
        }

        public int find(int x) {
            if (parent[x] == 0) return x;
            return parent[x] = find(parent[x]); // Path compression by halving.
        }

        // Return false if x, y are connected.
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;

            // Make root of smaller rank point to root of larger rank.
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }

            return true;
        }
    }
}
