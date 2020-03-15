package com.hit.basmath.interview.top_interview_questions.medium_collection.trees_and_graphs;

import com.hit.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
 * return its zigzag level order traversal as:
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class _103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }

    private void helper(TreeNode curr, List<List<Integer>> ans, int level) {
        if (curr == null) return;
        if (ans.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            ans.add(newLevel);
        }
        List<Integer> collection = ans.get(level);
        if (level % 2 == 0) {
            collection.add(curr.val);
        } else {
            collection.add(0, curr.val);
        }
        helper(curr.left, ans, level + 1);
        helper(curr.right, ans, level + 1);
    }
}
