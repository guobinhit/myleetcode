package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 814. Binary Tree Pruning
 * <p>
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 * <p>
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * <p>
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 * <p>
 * Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 * <p>
 * Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 * <p>
 * Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 * <p>
 * Note:
 * <p>
 * The binary tree will have at most 100 nodes.
 * The value of each node will only be 0 or 1.
 */
public class _814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (pruneTree(root.left) == null) root.left = null;
        if (pruneTree(root.right) == null) root.right = null;
        return (root.right == null && root.left == null && root.val == 0) ? null : root;
    }
}
