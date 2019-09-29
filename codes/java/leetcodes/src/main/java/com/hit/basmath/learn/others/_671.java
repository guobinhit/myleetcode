package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 671. Second Minimum Node In a Binary Tree
 * <p>
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 * <p>
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * <p>
 * If no such second minimum value exists, output -1 instead.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 2
 * / \
 * 2   2
 * <p>
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class _671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        // if value same as root value, need to find the next candidate
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }
}
