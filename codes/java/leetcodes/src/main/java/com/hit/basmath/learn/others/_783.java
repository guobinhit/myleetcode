package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 783. Minimum Distance Between BST Nodes
 * <p>
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * Example :
 * <p>
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * <p>
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * <p>
 * Note:
 * <p>
 * 1. The size of the BST will be between 2 and 100.
 * 2. The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class _783 {
    private Integer res;
    private Integer prev;

    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) {
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}
