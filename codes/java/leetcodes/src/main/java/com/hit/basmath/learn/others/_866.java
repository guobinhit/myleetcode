package com.hit.basmath.learn.others;

/**
 * 866. Prime Palindrome
 * <p>
 * Find the smallest prime palindrome greater than or equal to N.
 * <p>
 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
 * <p>
 * For example, 2,3,5,7,11 and 13 are primes.
 * <p>
 * Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.
 * <p>
 * For example, 12321 is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: 7
 * <p>
 * Example 2:
 * <p>
 * Input: 8
 * Output: 11
 * <p>
 * Example 3:
 * <p>
 * Input: 13
 * Output: 101
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^8
 * The answer is guaranteed to exist and be less than 2 * 10^8.
 */
public class _866 {
    public int primePalindrome(int N) {
        if (N == 1 || N == 2) return 2;
        if (N % 2 == 0) N++;
        while (true) {
            if (isPalindrome(N) && isPrime(N)) return N;
            N += 2;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_001;
        }
    }

    private boolean isPalindrome(int n) {
        if (n % 10 == 0 && n != 0) return false;
        int n1 = 0;
        while (n > n1) {
            n1 = n1 * 10 + (n % 10);
            n /= 10;
        }
        return n1 == n || n == n1 / 10;
    }

    private boolean isPrime(int n) {
        int end = (int) Math.sqrt(n);
        for (int i = 3; i <= end; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
