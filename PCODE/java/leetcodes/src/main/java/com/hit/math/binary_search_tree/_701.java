package com.hit.math.binary_search_tree;

import com.hit.utils.TreeNode;

/**
 * 701. Insert into a Binary Search Tree
 * <p>
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 * <p>
 * For example,
 * <p>
 * Given the tree:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * And the value to insert: 5
 * <p>
 * You can return this binary search tree:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * <p>
 * This tree is also valid:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 */
public class _701 {

    /**
     * Iteration method
     *
     * @param root pending root node
     * @param val  target value
     * @return tree node
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        while (true) {
            if (cur.val <= val) {
                if (cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if (cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    /**
     * Recursion method
     *
     * @param root pending root node
     * @param val  target value
     * @return tree node
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
