package com.hit.basmath.learn.others;

/**
 * 839. Similar String Groups
 * <p>
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
 * <p>
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 * <p>
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 * <p>
 * We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?
 * <p>
 * Example 1:
 * <p>
 * Input: ["tars","rats","arts","star"]
 * Output: 2
 * <p>
 * Note:
 * <p>
 * A.length <= 2000
 * A[i].length <= 1000
 * A.length * A[i].length <= 20000
 * All words in A consist of lowercase letters only.
 * All words in A have the same length and are anagrams of each other.
 * The judging time limit has been increased for this question.
 */
public class _839 {
    public int numSimilarGroups(String[] A) {
        final int n = A.length;

        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.find(i) == uf.find(j)) continue;

                String a = A[i], b = A[j];
                if (isSimilar(a, b)) uf.union(i, j);
            }
        }

        return uf.groups;
    }

    private boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++count > 2) return false;
        }

        return true;
    }

    private class UnionFind {
        int n, groups;
        int[] parent;

        UnionFind(int n) {
            this.n = n;

            groups = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        void union(int a, int b) {
            int p = find(a), q = find(b);

            if (p != q) {
                parent[p] = q;
                groups--;
            }
        }
    }
}
