package com.hit.basmath.learn.linked_list;

import com.hit.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. Palindrome Linked List
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * <p>
 * Output: false
 * <p>
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * <p>
 * Output: true
 * <p>
 * Follow up:
 * <p>
 * Could you do it in O(n) time and O(1) space?
 */
public class _234 {
    /**
     * This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].
     * <p>
     * In the beginning, set two pointers fast and slow starting at the head.
     * <p>
     * 1 -> 1 -> 2 -> 1 -> null
     * sf
     * (1) Move: fast pointer goes to the end, and slow goes to the middle.
     * <p>
     * 1 -> 1 -> 2 -> 1 -> null
     * s          f
     * (2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
     * <p>
     * 1 -> 1    null <- 2 <- 1
     * h                      s
     * (3) Compare: run the two pointers head and slow together and compare.
     * <p>
     * 1 -> 1    null <- 2 <- 1
     * h            s
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
