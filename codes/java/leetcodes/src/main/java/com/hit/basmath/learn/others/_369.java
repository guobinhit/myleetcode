package com.hit.basmath.learn.others;

import com.hit.common.ListNode;

/**
 * 369. Plus One Linked List
 * <p>
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1->2->3
 * <p>
 * Output:
 * 1->2->4
 */
public class _369 {
    public ListNode plusOne(ListNode head) {
        ListNode rNode = reverseList(head);
        ListNode node = rNode;
        while (node != null) {
            if (node.val + 1 <= 9) {
                node.val = node.val + 1;
                break;
            } else {
                node.val = 0;
                if (node.next == null) {
                    node.next = new ListNode(1);
                    break;
                }
                node = node.next;
            }
        }
        return reverseList(rNode);
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
