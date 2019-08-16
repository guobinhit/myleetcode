package com.hit.math.binary_tree;

import com.hit.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _94 {

    /**
     * Approach 1: Recursive Approach
     * <p>
     * The first method to solve this problem is using recursion.
     * This is the classical method and is straightforward.
     * We can define a helper function to implement recursion.
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity : O(n). The time complexity is O(n) because the recursive
     * function is T(n)=2*T(n/2)+1.
     * <p>
     * Space complexity : The worst case space required is O(n),
     * and in the average case it's O(log n) where nn is number of nodes.
     *
     * @param root root node
     * @return result list
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }


    /**
     * Approach 2: Iterating method using Stack
     * <p>
     * The strategy is very similiar to the first method, the different is using stack.
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity : O(n).
     * <p>
     * Space complexity : O(n).
     *
     * @param root root node
     * @return result list
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * Approach 3: Morris Traversal
     * <p>
     * In this method, we have to use a new data structure-Threaded Binary Tree, and the strategy is as follows:
     * <p>
     * Step 1: Initialize current as root
     * <p>
     * Step 2: While current is not NULL,
     * <p>
     * If current does not have left child
     * <p>
     * a. Add current’s value
     * <p>
     * b. Go to the right, i.e., current = current.right
     * <p>
     * Else
     * <p>
     * a. In current's left subtree, make current the right child of the rightmost node
     * <p>
     * b. Go to this left child, i.e., current = current.left
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity : O(n). To prove that the time complexity is O(n)O(n),
     * the biggest problem lies in finding the time complexity of finding the predecessor
     * nodes of all the nodes in the binary tree. Intuitively, the complexity is O(n log n),
     * because to find the predecessor node for a single node related to the height of the tree.
     * But in fact, finding the predecessor nodes for all nodes only needs O(n) time.
     * Because a binary Tree with nn nodes has n-1n−1 edges, the whole processing for each edges
     * up to 2 times, one is to locate a node, and the other is to find the predecessor node.
     * So the complexity is O(n)O(n).
     * <p>
     * Space complexity : O(n). Arraylist of size n is used.
     *
     * @param root root node
     * @return result list
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                // move to next right node
                curr = curr.right;
            } else {
                // has a left subtree
                pre = curr.left;
                // find rightmost
                while (pre.right != null) {
                    pre = pre.right;
                }
                // put cur after the pre node
                pre.right = curr;
                // store cur node
                TreeNode temp = curr;
                // move cur to the top of the new tree
                curr = curr.left;
                // original cur left be null, avoid infinite loops
                temp.left = null;
            }
        }
        return res;
    }
}
