package com.hit.math.n_ary_tree;

import com.hit.common.NaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 559. Maximum Depth of N-ary Tree
 * <p>
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * We should return its max depth, which is 3.
 * <p>
 * Note:
 * <p>
 * 1. The depth of the tree is at most 1000.
 * 2. The total number of nodes is at most 5000.
 */
public class _559 {
    public int maxDepth(NaryTreeNode root) {
        if (root == null) return 0;

        Queue<NaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NaryTreeNode current = queue.poll();
                for (NaryTreeNode child : current.children)
                    queue.offer(child);
            }

            depth++;
        }

        return depth;
    }
}
