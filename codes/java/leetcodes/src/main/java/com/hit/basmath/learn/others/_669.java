package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 669. Trim a Binary Search Tree
 * <p>
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 1
 * / \
 * 0   2
 * <p>
 * L = 1
 * R = 2
 * <p>
 * Output:
 * 1
 * \
 * 2
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 3
 * / \
 * 0   4
 * \
 * 2
 * /
 * 1
 * <p>
 * L = 1
 * R = 3
 * <p>
 * Output:
 * 3
 * /
 * 2
 * /
 * 1
 */
public class _669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
