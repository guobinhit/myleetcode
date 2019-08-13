package com.hit.math.linked_list;

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
        ListNode slow = head;
        ListNode fast = head;
        /**
         * If fast != null or fast.next != null is false,
         * it's mean this linkedlist is no circle
         */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /**
             * If fast == slow is true,
             * it's mean this linkedlist have circle
             */
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
