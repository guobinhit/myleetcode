package com.hit.math.queue_stack;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * <p>
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * <p>
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * <p>
 * Notes:
 * <p>
 * 1. You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * 2. Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * 3. You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class _232 {
    class MyQueue {

        //stack has the rule: last in, 1st out
        //maintain 2 stacks, "mainstk" for main operations (push, size and empty) and the other "tempstk" for (pop and peek)
        private Stack<Integer> mstk, tempstk;


        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            mstk = new Stack<>();
            tempstk = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            mstk.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return getFirst(true);
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return getFirst(false);

        }

        int getFirst(boolean withPop) {

            //if mainstk doesn't have anything return -1 (it's not required step as they said in the notes it will be guaranteed that it will have data)
            if (mstk.size() == 0)
                return -1;

            //pop everything from mstk and push them (in a revrse order) to tempstk
            while (mstk.size() > 0) {
                tempstk.push(mstk.pop());
            }
            //store the result
            int result = 0;
            if (withPop)
                result = tempstk.pop();
            else
                result = tempstk.peek();

            //push them back to mstk in case we need to do more push ops
            while (tempstk.size() > 0) {
                mstk.push(tempstk.pop());
            }

            return result;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return mstk.size() == 0;
        }
    }
}
