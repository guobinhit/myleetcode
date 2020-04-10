package com.hit.basmath.learn.others;

import com.hit.common.ListNode;

/**
 * 725. Split Linked List in Parts
 * <p>
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * <p>
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * <p>
 * Return a List of ListNode's representing the linked list parts that are formed.
 * <p>
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * <p>
 * Example 1:
 * <p>
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * <p>
 * Example 2:
 * <p>
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * <p>
 * Note:
 * <p>
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 */
public class _725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int n = 0;
        for (ListNode curr = root; curr != null; curr = curr.next) {
            n++;
        }
        int perpart = n / k;
        int remain = n % k;
        ListNode head = root;
        ListNode prev = null;
        for (int i = 0; i < k; i++, remain--) {
            res[i] = head;
            for (int j = 0; j < perpart + (remain > 0 ? 1 : 0); j++) {
                prev = head;
                head = head.next;
            }
            if (prev != null) {
                prev.next = null;
            }

        }
        return res;
    }
}
