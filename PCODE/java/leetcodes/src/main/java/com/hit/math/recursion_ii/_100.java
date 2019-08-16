package com.hit.math.recursion_ii;

import com.hit.common.TreeNode;

import java.util.ArrayDeque;

/**
 * 100. Same Tree
 * <p>
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Example 1:
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input:     1         1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * Output: false
 */
public class _100 {

    /**
     * Approach 1: Recursion
     * <p>
     * <p>
     * The simplest strategy here is to use recursion. Check if p and q nodes are not None,
     * and their values are equal. If all checks are OK, do the same for the child nodes recursively.
     *
     * @param p p node
     * @param q q node
     * @return true or false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }


    /**
     * Approach 2: Iteration
     * <p>
     * <p>
     * Start from the root and then at each iteration pop the current node out of the deque.
     * Then do the same checks as in the approach 1 :
     * 1. p and p are not None,
     * 2. p.val is equal to q.val,
     * and if checks are OK, push the child nodes.
     *
     * @param p p node
     * @param q q node
     * @return true or false
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)) return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }
}
