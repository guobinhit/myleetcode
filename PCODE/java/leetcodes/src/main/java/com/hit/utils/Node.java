package com.hit.utils;

/**
 * author:Charies Gavin
 * date:2018/8/11,15:51
 * https:github.com/guobinhit
 * description: Node
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
