package com.hit.basmath.learn.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1195. Fizz Buzz Multithreaded
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to n, however:
 * <p>
 * If the number is divisible by 3, output "fizz".
 * If the number is divisible by 5, output "buzz".
 * If the number is divisible by both 3 and 5, output "fizzbuzz".
 * <p>
 * For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
 * <p>
 * Suppose you are given the following code:
 * <p>
 * class FizzBuzz {
 * public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * <p>
 * Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:
 * <p>
 * Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
 * Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
 * Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
 * Thread D will call number() which should only output the numbers.
 */
public class _1195 {
    class FizzBuzz {
        private final int n;
        private final Semaphore[] semaphores;
        private final int NUM = 0;
        private final int FIZZ = 1;
        private final int BUZZ = 2;
        private final int FIZZBUZZ = 3;

        public FizzBuzz(int n) {
            this.n = n;
            semaphores = new Semaphore[4];
            semaphores[NUM] = new Semaphore(1);
            semaphores[FIZZ] = new Semaphore(0);
            semaphores[BUZZ] = new Semaphore(0);
            semaphores[FIZZBUZZ] = new Semaphore(0);
        }

        private synchronized Semaphore getSemaphore(int x) {

            if (x % 3 == 0 && x % 5 == 0) {
                return semaphores[FIZZBUZZ];
            }
            if (x % 3 == 0) {
                return semaphores[FIZZ];
            }
            if (x % 5 == 0) {
                return semaphores[BUZZ];
            }
            return semaphores[NUM];
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {

            for (int i = 3; i <= n; i += 3) {

                if (i % 5 == 0) continue;
                getSemaphore(i).acquire();
                printFizz.run();
                getSemaphore(i + 1).release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {

            for (int i = 5; i <= n; i += 5) {

                if (i % 3 == 0) continue;
                getSemaphore(i).acquire();
                printBuzz.run();
                getSemaphore(i + 1).release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i += 15) {

                getSemaphore(i).acquire();
                printFizzBuzz.run();
                getSemaphore(i + 1).release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {

                if (i % 3 != 0 && i % 5 != 0) {

                    getSemaphore(i).acquire();
                    printNumber.accept(i);
                    getSemaphore(i + 1).release();
                }
            }
        }
    }
}
