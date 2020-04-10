package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 * <p>
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * <p>
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * <p>
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * <p>
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation:
 * <p>
 * We return the node with value 2, colored in yellow in the diagram.
 * The nodes colored in blue are the deepest nodes of the tree.
 * The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
 * The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
 * Both the input and output have TreeNode type.
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree will be between 1 and 500.
 * The values of each node are unique.
 */
public class _865 {
    int maxDepth = -1;
    TreeNode[] result = new TreeNode[1];

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return root;
        result[0] = null;
        getNode(root, 0);
        return result[0];
    }

    public int getNode(TreeNode root, int depth) {
        if (root == null)
            return depth;
        int l = getNode(root.left, depth + 1);
        int r = getNode(root.right, depth + 1);

        // both left and right depth are same and if it is greater than or equal to the maxDepth so far, UPDATE result.
        //  `=` in l >= maxDepth, implies that the all the nodes with maximum depth are considered.
        if (l == r && l >= maxDepth) {
            maxDepth = l;
            result[0] = root;
        }

        // return the maximum depth that was found in this subtree.
        return Math.max(l, r);
    }
}
