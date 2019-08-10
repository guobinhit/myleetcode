package com.hit.math.binary_tree;

import com.hit.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [3,2,1]
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                // Reverse the process of preorder
                result.addFirst(root.val);
                // Reverse the process of preorder
                root = root.right;
            } else {
                TreeNode node = stack.pop();
                // Reverse the process of preorder
                root = node.left;
            }
        }
        return result;
    }
}
