package com.hit.common;

/**
 * author:Charies Gavin
 * date:2018/9/20,17:51
 * https:github.com/guobinhit
 * description: Doubly List Node
 */
public class DoublyListNode {
    public int val;
    public DoublyListNode next;
    public DoublyListNode prev;

    public DoublyListNode(int x) {
        val = x;
        next = null;
        prev = null;
    }
}
