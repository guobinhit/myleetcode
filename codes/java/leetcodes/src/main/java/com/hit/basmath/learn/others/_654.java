package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 654. Maximum Binary Tree
 * <p>
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * <p>
 * Note: The size of the given array will be in the range [1,1000].
 */
public class _654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}
