package com.hit.basmath.learn.queue_stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * <p>
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * <p>
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * <p>
 * Notes:
 * <p>
 * 1. You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * 2. Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * 3. You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class _225 {
    class MyStack {

        private Queue<Integer> pusher = new ArrayDeque<>();
        private Queue<Integer> popper = new ArrayDeque<>();

        private void exchange() {
            Queue<Integer> temp = pusher;
            pusher = popper;
            popper = temp;
        }

        public void push(int x) {
            pusher.add(x);
            while (!popper.isEmpty()) pusher.add(popper.poll());
            exchange();
        }

        public int pop() {
            return !popper.isEmpty() ? popper.poll() : Integer.MAX_VALUE;
        }

        public int top() {
            return !popper.isEmpty() ? popper.peek() : Integer.MAX_VALUE;
        }

        public boolean empty() {
            return popper.isEmpty();
        }
    }
}
