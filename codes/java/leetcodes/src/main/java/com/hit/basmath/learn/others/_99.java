package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 99. Recover Binary Search Tree
 * <p>
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * Output: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * <p>
 * Example 2:
 * <p>
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * Output: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * <p>
 * Follow up:
 * <p>
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class _99 {
    public void recoverTree(TreeNode root) {

        TreeNode first = null;     // first node need to be swap
        TreeNode second = null;    // second node need to be swap
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);  //previous node.

        while (root != null) {
            TreeNode node = root.left;

            // If left is not null, we need to find the rightmost node of left subtree,
            // Set its right child to current node
            if (node != null) {

                //find the rightmost
                while (node.right != null && node.right != root) {
                    node = node.right;
                }

                //There are two cases,
                //null: first time we access current, set node.right to current and move to left child of current and continue;
                //current: we accessed current before, thus we've finished traversing left subtree, set node.right back to null;
                if (node.right == null) {
                    node.right = root;
                    root = root.left;
                    continue;
                } else {
                    node.right = null;
                }
            }

            // compare current node with previous node
            if (root.val < pre.val) {
                // first time we enconter reversed order, we set previous node to first
                if (first == null) {
                    first = pre;
                }
                //In case that two nodes are successive, we set second to current every time.
                second = root;
            }
            pre = root;
            root = root.right;
        }

        //swap the value;
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }
}
