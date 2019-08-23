package com.hit.basmath.learn.others;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * <p>
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * <p>
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * <p>
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: "1,#"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: "9,#,#,1"
 * Output: false
 */
public class _331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
