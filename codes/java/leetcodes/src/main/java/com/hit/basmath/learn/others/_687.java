package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 687. Longest Univalue Path
 * <p>
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output: 2
 * <p>
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class _687 {
    private int len = 0; // global variable

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        len = 0;
        getLen(root, root.val);
        return len;
    }

    private int getLen(TreeNode node, int val) {
        if (node == null) return 0;
        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);
        len = Math.max(len, left + right);
        if (val == node.val) return Math.max(left, right) + 1;
        return 0;
    }
}
