package com.hit.basmath.learn.concurrency;

/**
 * 1114. Print in Order
 * <p>
 * Suppose we have a class:
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * <p>
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * <p>
 * Example 2:
 * <p>
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 * <p>
 * Note:
 * <p>
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 */
public class _1114 {
    class Foo {

        private volatile boolean onePrinted;
        private volatile boolean twoPrinted;

        public Foo() {
            onePrinted = false;
            twoPrinted = false;
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            onePrinted = true;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (!onePrinted) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            twoPrinted = true;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (!twoPrinted) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
