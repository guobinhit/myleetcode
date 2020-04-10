package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

import java.util.Stack;

/**
 * 653. Two Sum IV - Input is a BST
 * <p>
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 */
public class _653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Stack<TreeNode> l_stack = new Stack<>();
        Stack<TreeNode> r_stack = new Stack<>();
        stackAdd(l_stack, root, true);
        stackAdd(r_stack, root, false);
        while (l_stack.peek() != r_stack.peek()) {
            int n = l_stack.peek().val + r_stack.peek().val;
            if (n == k) {
                return true;
            } else if (n > k) {
                stackNext(r_stack, false);
            } else {
                stackNext(l_stack, true);
            }
        }
        return false;
    }

    private void stackAdd(Stack<TreeNode> stack, TreeNode node, boolean isLeft) {
        while (node != null) {
            stack.push(node);
            node = (isLeft) ? node.left : node.right;
        }
    }

    private void stackNext(Stack<TreeNode> stack, boolean isLeft) {
        TreeNode node = stack.pop();
        if (isLeft) {
            stackAdd(stack, node.right, isLeft);
        } else {
            stackAdd(stack, node.left, isLeft);
        }
    }
}
