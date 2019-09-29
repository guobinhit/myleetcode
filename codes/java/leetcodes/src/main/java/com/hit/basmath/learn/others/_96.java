package com.hit.basmath.learn.others;

/**
 * 96. Unique Binary Search Trees
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * <p>
 * Explanation:
 * <p>
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class _96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level <= n; level++)
            for (int root = 1; root <= level; root++)
                dp[level] += dp[level - root] * dp[root - 1];
        return dp[n];
    }
}
