package com.hit.basmath.learn.concurrency;

/**
 * 1115. Print FooBar Alternately
 * <p>
 * Suppose you are given the following code:
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * <p>
 * The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 */
public class _1115 {
    class FooBar {
        private int n;

        volatile boolean callFoo;
        volatile boolean callBar;

        public FooBar(int n) {
            this.n = n;
            callFoo = true;
            callBar = false;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (callBar) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                callFoo = false;
                callBar = true;
                notifyAll();
            }
        }

        public synchronized void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (callFoo) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                callBar = false;
                callFoo = true;
                notifyAll();
            }
        }
    }
}
