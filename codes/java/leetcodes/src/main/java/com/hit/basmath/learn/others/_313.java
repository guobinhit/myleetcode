package com.hit.basmath.learn.others;

/**
 * 313. Super Ugly Number
 * <p>
 * Write a program to find the nth super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * <p>
 * Example:
 * <p>
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * <p>
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 * <p>
 * Note:
 * <p>
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class _313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ptr = new int[primes.length];
        int[] ugly = new int[n + 1];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[ptr[j]] * primes[j] < min) {
                    min = ugly[ptr[j]] * primes[j];
                    minIndex = j;
                } else if (ugly[ptr[j]] * primes[j] == min) {
                    ptr[j]++;
                }
            }

            ugly[i] = min;
            ptr[minIndex]++;
        }

        return ugly[n - 1];
    }
}
