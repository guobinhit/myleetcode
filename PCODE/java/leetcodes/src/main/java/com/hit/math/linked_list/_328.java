package com.hit.math.linked_list;

import com.hit.math.utils.ListNode;

/**
 * 328. Odd Even Linked List
 * <p>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * <p>
 * Output: 1->3->5->2->4->NULL
 * <p>
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * <p>
 * Output: 2->3->6->7->1->5->4->NULL
 * <p>
 * Note:
 * <p>
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class _328 {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            /**
             * initial odd node and even node
             */
            ListNode odd = head;
            ListNode even = head.next;
            /**
             * keep first even node and when while loop over,
             * linked last odd node and first even node
             */
            ListNode evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            /**
             * linked last odd node and first even node, keep link list completed
             */
            odd.next = evenHead;
        }
        return head;
    }
}
