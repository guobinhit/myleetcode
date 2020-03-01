package com.hit.basmath.learn.binary_tree;

import com.hit.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its level order traversal as:
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class _102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(ans, root, 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, TreeNode node, int level) {
        // start the current level
        if (ans.size() == level) ans.add(new ArrayList<Integer>());
        // fulfil the current level
        ans.get(level).add(node.val);
        // process child nodes for the next level
        if (node.left != null) helper(ans, node.left, level + 1);
        if (node.right != null) helper(ans, node.right, level + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // start the current level
            ans.add(new ArrayList<Integer>());
            // number of elements in the current level
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.remove();
                // fulfill the current level
                ans.get(level).add(node.val);
                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return ans;
    }
}
