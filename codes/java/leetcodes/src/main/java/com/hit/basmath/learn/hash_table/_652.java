package com.hit.basmath.learn.hash_table;

import com.hit.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 * <p>
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * <p>
 * Two trees are duplicate if they have the same structure with same node values.
 * <p>
 * Example 1:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   2   4
 * /
 * 4
 * <p>
 * The following are two duplicate subtrees:
 * <p>
 * 2
 * /
 * 4
 * <p>
 * and
 * <p>
 * 4
 * <p>
 * Therefore, you need to return above trees' root in the form of a list.
 */
public class _652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    private String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
