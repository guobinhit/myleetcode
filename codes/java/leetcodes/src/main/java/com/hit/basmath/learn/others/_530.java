package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 530. Minimum Absolute Difference in BST
 * <p>
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * <p>
 * Note: There are at least two nodes in this BST.
 */
public class _530 {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
}
