package com.hit.math.linked_list;

import com.hit.math.utils.ListNode;

/**
 * 203. Remove Linked List Elements
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * <p>
 * Output: 1->2->3->4->5
 */
public class _203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
