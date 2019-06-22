package com.hit.utils;

/**
 * author:Charies Gavin
 * date:2018/9/20,17:51
 * https:github.com/guobinhit
 * description: Doubly List Node
 */
public class DoublyListNode {
    public static int val;
    public static DoublyListNode next;
    public static DoublyListNode prev;

    public DoublyListNode(int x) {
        val = x;
        next = null;
        prev = null;
    }
}
