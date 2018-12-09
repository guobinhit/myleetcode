package com.hit.math.queue_stack;

/**
 * 622. Design Circular Queue
 * <p>
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 * <p>
 * <p>
 * Example:
 * <p>
 * MyCircularQueue circularQueue = new MycircularQueue(3); // set the size to be 3
 * circularQueue.enQueue(1);  // return true
 * circularQueue.enQueue(2);  // return true
 * circularQueue.enQueue(3);  // return true
 * circularQueue.enQueue(4);  // return false, the queue is full
 * circularQueue.Rear();  // return 3
 * circularQueue.isFull();  // return true
 * circularQueue.deQueue();  // return true
 * circularQueue.enQueue(4);  // return true
 * circularQueue.Rear();  // return 4
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Queue library.
 */
public class _622 {
    public static class MyCircularQueue {
        private final int[] circularQueue;
        private int front, rear = -1, realLength = 0;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            circularQueue = new int[k];
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (!isFull()) {
                rear = (rear + 1) % circularQueue.length;
                circularQueue[rear] = value;
                realLength++;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (!isEmpty()) {
                front = (front + 1) % circularQueue.length;
                realLength--;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            return isEmpty() ? -1 : circularQueue[front];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            return isEmpty() ? -1 : circularQueue[rear];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return realLength == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return realLength == circularQueue.length;
        }
    }

    /**
     * This implementation is similar with MyCircularQueue, but can be referenced
     */
    public static class MyCircularQueue2 {

        private int[] data;
        private int head;
        private int tail;
        private int size;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue2(int k) {
            data = new int[k];
            head = -1;
            tail = -1;
            size = k;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull() == true) {
                return false;
            }
            if (isEmpty() == true) {
                head = 0;
            }
            tail = (tail + 1) % size;
            data[tail] = value;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty() == true) {
                return false;
            }
            if (head == tail) {
                head = -1;
                tail = -1;
                return true;
            }
            head = (head + 1) % size;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty() == true) {
                return -1;
            }
            return data[head];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty() == true) {
                return -1;
            }
            return data[tail];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return head == -1;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return ((tail + 1) % size) == head;
        }
    }

    public static void main(String[] args) {
        _622.MyCircularQueue circularQueue = new _622.MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.Front());  // return 1
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }
}
