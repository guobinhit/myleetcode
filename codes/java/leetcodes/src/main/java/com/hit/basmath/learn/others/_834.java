package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 834. Sum of Distances in Tree
 * <p>
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 * <p>
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 * <p>
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 * <p>
 * Example 1:
 * <p>
 * Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation:
 * Here is a diagram of the given tree:
 * 0
 * / \
 * 1   2
 * /|\
 * 3 4 5
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 * <p>
 * Note: 1 <= N <= 10000
 */
public class _834 {
    private int[] res, count;
    private ArrayList<HashSet<Integer>> tree;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N; ++i)
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }


    private void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }
}
