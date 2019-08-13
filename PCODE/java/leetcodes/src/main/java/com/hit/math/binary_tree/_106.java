package com.hit.math.binary_tree;

import com.hit.common.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * <p>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * <p>
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * <p>
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class _106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }

        return root;
    }


    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    private TreeNode buildTreeHelper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreeHelper(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1, hm);
        TreeNode rightchild = buildTreeHelper(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
