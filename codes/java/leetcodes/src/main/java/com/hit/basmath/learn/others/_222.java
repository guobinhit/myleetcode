package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 * <p>
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 */
public class _222 {
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                        : (1 << h - 1) + countNodes(root.left);
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}
