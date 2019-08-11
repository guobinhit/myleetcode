package com.hit.math.binary_tree;

import com.hit.utils.Node;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * <p>
 * Given a binary tree
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Example:
 * <p>
 * Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 * <p>
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 * <p>
 * Note:
 * <p>
 * 1. You may only use constant extra space.
 * 2. Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 */
public class _117 {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                cur.left.next = (cur.right != null) ? cur.right : getNext(cur);
            }

            if (cur.right != null) {
                cur.right.next = getNext(cur);
            }

            cur = cur.next;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }

    private Node getNext(Node root) {
        Node temp = root.next;

        while (temp != null) {
            if (temp.left != null)
                return temp.left;

            if (temp.right != null)
                return temp.right;

            temp = temp.next;
        }

        return null;
    }
}
