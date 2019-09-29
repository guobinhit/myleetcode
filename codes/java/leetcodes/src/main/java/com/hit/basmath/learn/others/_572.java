package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 572. Subtree of Another Tree
 * <p>
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * <p>
 * Given tree s:
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * <p>
 * Given tree t:
 * 4
 * / \
 * 1   2
 * <p>
 * Return true, because t has the same structure and node values with a subtree of s.
 * <p>
 * Example 2:
 * <p>
 * Given tree s:
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * <p>
 * Given tree t:
 * 4
 * / \
 * 1   2
 * <p>
 * Return false.
 */
public class _572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
