package com.hit.basmath.learn.linked_list;

import com.hit.common.ListNode;

/**
 * 142. Linked List Cycle II
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Follow up:
 * <p>
 * Can you solve it without using extra space?
 */
public class _142 {
    public ListNode detectCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        /**
         * If fast != null or fast.next != null is false,
         * it's mean this linkedlist is no circle
         */
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            /**
             * If fast == slow is true,
             * it's mean this linkedlist have circle
             */
            if (runner == walker) {
                ListNode walker2 = head;
                while (walker2 != walker) {
                    walker = walker.next;
                    walker2 = walker2.next;
                }
                return walker;
            }
        }
        return null;
    }
}
