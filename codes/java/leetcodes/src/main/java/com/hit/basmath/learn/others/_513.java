package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 513. Find Bottom Left Tree Value
 * <p>
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output: 7
 * <p>
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class _513 {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0, 0});
    }

    private int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1] < depth) {
            res[0] = root.val;
            res[1] = depth;
        }
        if (root.left != null) findBottomLeftValue(root.left, depth + 1, res);
        if (root.right != null) findBottomLeftValue(root.right, depth + 1, res);
        return res[0];
    }
}
