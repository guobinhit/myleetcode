package com.hit.basmath.learn.linked_list;

/**
 * 707. Design Linked List
 * <p>
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 */
public class _707 {
    public static class MyLinkedList {
        /**
         * It's a inner static class, in order to handle element linked
         */
        private class Node {
            /**
             * The value of every node
             */
            int value;
            /**
             * It's a reference, point to next node
             */
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        /**
         * Initial head is null and length is 0
         */
        Node head = null;
        private int length = 0;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
        }

        /**
         * Return the length of this MyLinkedList
         */
        public int length() {
            return length;
        }

        /**
         * Get the value of the index-th node in the linked list.
         * If the index is invalid, return -1.
         */
        public int get(int index) {
            Node result = findAtIndex(index);
            return result != null ? result.value : -1;
        }

        /**
         * Add a node of value val before the first element of the linked list.
         * After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(length, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > length) {
                return;
            }
            Node nodeAtIndex = findAtIndex(index - 1);
            Node node = new Node(val);
            if (nodeAtIndex == null) {
                head = node;
            } else if (index == 0) {
                node.next = head;
                head = node;
            } else {
                node.next = nodeAtIndex.next;
                nodeAtIndex.next = node;
            }
            length++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (length == 0 || index > length - 1 || index < 0) {
                return;
            }
            if (index == 0) {
                head = head.next;
            } else {
                Node nodeAtIndex = findAtIndex(index - 1);
                if (nodeAtIndex.next != null) {
                    nodeAtIndex.next = nodeAtIndex.next.next;
                }
            }
            length--;
        }

        /**
         * Override toString() method of Object
         */
        public String toString() {
            String result = "";
            if (head == null) {
                return result;
            }
            Node node = head;
            while (node != null) {
                if (result == "") {
                    result += head.value;
                } else {
                    result += "->" + node.value;
                }
                node = node.next;
            }
            return result;
        }

        /**
         * Get node of index
         */
        private Node findAtIndex(int index) {
            if (length == 0 || index > length - 1) {
                return null;
            }
            if (index <= 0) {
                return head;
            }
            Node result = head.next;
            int idx = 1;
            while (idx < index) {
                result = result.next;
                idx++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);        // linked list becomes 1->2->3
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(1));        // returns 2
        linkedList.deleteAtIndex(1);                  // now the linked list is 1->3
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(1));        // returns 3
    }
}
