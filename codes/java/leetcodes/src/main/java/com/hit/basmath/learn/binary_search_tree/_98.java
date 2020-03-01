package com.hit.basmath.learn.binary_search_tree;

import com.hit.common.TreeNode;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a root contains only nodes with keys less than the root's key.
 * The right subtree of a root contains only nodes with keys greater than the root's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root root's value is 5 but its right child's value is 4.
 */
public class _98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!helper(root.left, lower, val)) return false;
        if (!helper(root.right, val, upper)) return false;
        return true;
    }
}
