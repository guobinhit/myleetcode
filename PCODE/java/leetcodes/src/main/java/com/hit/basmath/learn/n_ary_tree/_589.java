package com.hit.basmath.learn.n_ary_tree;

import com.hit.common.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal
 * <p>
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * <p>
 * Note:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 */
public class _589 {

    public List<Integer> preorder(NaryTreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        list.add(root.val);
        for (NaryTreeNode node : root.children)
            preorder(node);

        return list;
    }
}
