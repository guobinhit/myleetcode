package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 872. Leaf-Similar Trees
 * <p>
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * Note:
 * <p>
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class _872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return traverse(root1).equals(traverse(root2));
    }

    private String traverse(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "-";
        return traverse(root.left) + traverse(root.right);
    }
}
