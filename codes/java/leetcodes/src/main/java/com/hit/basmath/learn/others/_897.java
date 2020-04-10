package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 897. Increasing Order Search Tree
 * <p>
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 * <p>
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 * /        / \
 * 1        7   9
 * <p>
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * 9
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 */
public class _897 {
    private TreeNode prev = null, head = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        if (prev != null) {
            root.left = null; // we no  longer needs the left  side of the node, so set it to null
            prev.right = root;
        }
        if (head == null) head = root; // record the most left node as it will be our root
        prev = root; //keep track of the prev node
        increasingBST(root.right);
        return head;
    }
}
