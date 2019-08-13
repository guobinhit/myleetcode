package com.hit.math.linked_list;

import com.hit.common.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class _19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        /**
         * Move fast in front so that the gap between slow and fast becomes n
         */
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        /**
         * Move fast to the end, maintaining the gap
         */
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        /**
         * Skip the desired node
         */
        slow.next = slow.next.next;
        return start.next;
    }
}
