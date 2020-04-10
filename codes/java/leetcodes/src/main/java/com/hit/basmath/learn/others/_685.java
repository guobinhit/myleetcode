package com.hit.basmath.learn.others;

/**
 * 685. Redundant Connection II
 * <p>
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
 * <p>
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * <p>
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 * 1
 * / \
 * v   v
 * 2-->3
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * <p>
 * Note:
 * <p>
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class _685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] roots = new int[edges.length + 1];
        for (int i = 0; i < roots.length; i++) roots[i] = i;

        int[] candidate1 = null, candidate2 = null;
        for (int[] e : edges) {
            int rootx = find(roots, e[0]), rooty = find(roots, e[1]);
            if (rooty != e[1]) candidate1 = e; // _Record the last edge which results in "multiple parents" issue
            else if (rootx == rooty) candidate2 = e; // Record last edge which results in "cycle" issue, if any.
            else roots[rooty] = rootx;
        }

        // If there is only one issue, return this one.
        if (candidate1 == null) return candidate2;
        if (candidate2 == null) return candidate1;

        /* If both issues present, then the answer should be the first edge which results in "multiple parents" issue
        The reason is, when an issue happens, we skip the "union" process.
		Therefore, if both issues happen, it means the incorrent edge which results in "multiple parents" was ignored. */
        for (int[] e : edges) if (e[1] == candidate1[1]) return e;

        return new int[2];
    }

    private int find(int[] roots, int i) {
        while (i != roots[i]) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}
