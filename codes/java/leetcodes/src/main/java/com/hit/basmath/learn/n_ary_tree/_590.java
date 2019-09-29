package com.hit.basmath.learn.n_ary_tree;

import com.hit.common.NaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 590. N-ary Tree Postorder Traversal
 * <p>
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * <p>
 * Note:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 */
public class _590 {
    public List<Integer> postorder(NaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<NaryTreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (NaryTreeNode node : root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}
