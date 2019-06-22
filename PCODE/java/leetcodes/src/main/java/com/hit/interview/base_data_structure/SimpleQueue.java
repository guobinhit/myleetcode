package com.hit.interview.base_data_structure;

import com.hit.utils.ListNode;

/**
 * author:Charies Gavin
 * date:2019/1/21,11:39
 * https:github.com/guobinhit
 * description: 简单的队列
 */
public class SimpleQueue {
    ListNode first, last;

    void enqueue(Object item) {
        if (last != null) {
            last.next = new ListNode(Integer.valueOf((String) item));
            last = last.next;
        } else {
            last = new ListNode(Integer.valueOf((String) item));
            first = last;
        }
    }

    Object dequeue() {
        if (first != null) {
            Object item = first.val;
            first = first.next;
            return item;
        }
        return null;
    }
}
