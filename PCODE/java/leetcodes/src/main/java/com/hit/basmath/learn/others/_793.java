package com.hit.basmath.learn.others;

/**
 * 793. Preimage Size of Factorial Zeroes Function
 * <p>
 * Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)
 * <p>
 * For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end. Given K, find how many non-negative integers x have the property that f(x) = K.
 * <p>
 * Example 1:
 * <p>
 * Input: K = 0
 * Output: 5
 * Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
 * <p>
 * Example 2:
 * <p>
 * Input: K = 5
 * Output: 0
 * Explanation: There is no x such that x! ends in K = 5 zeroes.
 * <p>
 * Note:
 * <p>
 * K will be an integer in the range [0, 10^9].
 */
public class _793 {
    public int preimageSizeFZF(int K) {
        if (K < 5) {
            return 5;
        }
        int d = 1;
        while (d * 5 + 1 <= K) {
            d = d * 5 + 1;
        }
        if (K / d == 5) {
            return 0;
        }
        return preimageSizeFZF(K % d);
    }
}
