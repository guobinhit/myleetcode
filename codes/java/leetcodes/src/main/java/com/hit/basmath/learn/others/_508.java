package com.hit.basmath.learn.others;

import com.hit.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum
 * <p>
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * Examples 1
 * <p>
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -3
 * <p>
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * <p>
 * Examples 2
 * <p>
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -5
 * <p>
 * return [2], since 2 happens twice, however -5 only occur once.
 * <p>
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class _508 {
    Map<Integer, Integer> map;
    int cnt = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        map = new HashMap<>();
        int curr = helper(root, 0);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> met : map.entrySet()) {
            if (met.getValue() == cnt)
                res.add(met.getKey());
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }

    private int helper(TreeNode root, int curr) {
        if (root == null)
            return curr;

        curr = curr + root.val;
        if (root.left != null)
            curr = curr + helper(root.left, 0);
        if (root.right != null)
            curr = curr + helper(root.right, 0);

        int num = map.getOrDefault(curr, 0) + 1;
        cnt = Math.max(cnt, num);
        map.put(curr, num);

        return curr;
    }
}
