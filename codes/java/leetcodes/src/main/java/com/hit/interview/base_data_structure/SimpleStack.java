package com.hit.interview.base_data_structure;

import com.hit.common.ListNode;

/**
 * author:Charies Gavin
 * date:2019/1/21,11:30
 * https:github.com/guobinhit
 * description: 简单的栈
 */
public class SimpleStack {
    ListNode top;

    void push(Object item) {
        ListNode t = new ListNode(Integer.valueOf((String) item));
        if (top != null) {
            t.next = top;
            top = t;
        }
    }

    Object pop() {
        if (top != null) {
            Object item = top.val;
            top = top.next;
            return item;
        }
        return null;
    }

    Object peek() {
        return top.val;
    }
}
