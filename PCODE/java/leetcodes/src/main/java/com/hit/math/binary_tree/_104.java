package com.hit.math.binary_tree;

import com.hit.utils.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its depth = 3.
 */
public class _104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = (root.left == null) ? 0 : maxDepth(root.left);
        int rightMax = (root.right == null) ? 0 : maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}
