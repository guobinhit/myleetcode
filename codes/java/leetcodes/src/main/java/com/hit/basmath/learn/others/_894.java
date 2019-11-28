package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. All Possible Full Binary Trees
 * <p>
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * <p>
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 * <p>
 * Each node of each tree in the answer must have node.val = 0.
 * <p>
 * You may return the final list of trees in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 20
 */
public class _894 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N = N - 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
