package com.hit.math.linked_list;

import com.hit.math.utils.ListNode;

/**
 * 141. Linked List Cycle
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * <p>
 * Can you solve it without using extra space?
 */
public class _141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        /**
         * Use two pointers, walker and runner
         */
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            /**
             * walker moves step by step,
             * runner moves two steps at time
             */
            walker = walker.next;
            runner = runner.next.next;
            /**
             * If the Linked List has a cycle walker and runner will meet at some point
             */
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
}
