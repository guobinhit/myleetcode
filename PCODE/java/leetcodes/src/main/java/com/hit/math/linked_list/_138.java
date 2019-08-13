package com.hit.math.linked_list;

import java.util.LinkedList;

/**
 * 138. Copy List with Random Pointer
 * <p>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * Explanation:
 * <p>
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 * <p>
 * Note:
 * <p>
 * You must return the copy of the given head as a reference to the cloned list.
 */
public class _138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node newHead = new Node(head.val, head.next, null);

        LinkedList<Node> newList = new LinkedList<Node>();
        LinkedList<Node> originalList = new LinkedList<Node>();

        originalList.add(head);
        newList.add(newHead);

        Node curr = newHead.next;
        Node last = newHead;

        while (curr != null) {
            Node newNode = new Node(curr.val, curr.next, null);

            newList.add(newNode);
            originalList.add(curr);

            last.next = newNode;
            curr = curr.next;
            last = last.next;
        }


        //let's build random then..
        for (int i = 0; i < originalList.size(); i++) {
            curr = newList.get(i);
            last = originalList.get(i);

            int k = originalList.indexOf(last.random);

            if (k != -1)
                curr.random = newList.get(k);
        }

        return newHead;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
