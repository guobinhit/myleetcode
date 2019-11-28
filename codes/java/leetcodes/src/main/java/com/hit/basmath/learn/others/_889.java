package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 * <p>
 * Return any binary tree that matches the given preorder and postorder traversals.
 * <p>
 * Values in the traversals pre and post are distinct positive integers.
 * <p>
 * Example 1:
 * <p>
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * <p>
 * Note:
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class _889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode constructFromPrePost(int[] pre, int preL, int preR, int[] post, int postL, int postR) {
        if (preL > preR || postL > postR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        if (preL == preR) return root;

        int index = -1;
        for (int i = postL; i < postR; i++) {
            if (pre[preL + 1] == post[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) return root;

        root.left = constructFromPrePost(pre, preL + 1, preL + 1 + (index - postL), post, postL, index);
        root.right = constructFromPrePost(pre, preL + 1 + (index - postL) + 1, preR, post, index + 1, postR);
        return root;
    }
}
