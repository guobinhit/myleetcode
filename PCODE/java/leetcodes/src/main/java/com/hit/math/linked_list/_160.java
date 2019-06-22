package com.hit.math.linked_list;

import com.hit.utils.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗
 * B:     b1 → b2 → b3
 * <p>
 * begin to intersect at node c1.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * Boundary check
         */
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        /**
         * If a & b have different len,
         * then we will stop the loop after second iteration
         */
        while (nodeA != nodeB) {
            /**
             * For the end of first iteration,
             * we just reset the pointer to the head of another linkedlist
             */
            nodeA = (nodeA == null ? headB : nodeA.next);
            nodeB = (nodeB == null ? headA : nodeB.next);
        }
        return nodeA;
    }
}
