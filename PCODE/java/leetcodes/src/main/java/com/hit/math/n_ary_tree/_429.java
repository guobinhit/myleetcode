package com.hit.math.n_ary_tree;

import com.hit.utils.NaryTreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal
 * <p>
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * We should return its level order traversal:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * Note:
 * <p>
 * 1. The depth of the tree is at most 1000.
 * 2. The total number of nodes is at most 5000.
 */
public class _429 {
    public List<List<Integer>> levelOrder(NaryTreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null) return ret;

        Queue<NaryTreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                NaryTreeNode curr = queue.poll();
                curLevel.add(curr.val);
                for (NaryTreeNode c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }
}
