package com.hit.basmath.learn.others;

/**
 * 878. Nth Magical Number
 * <p>
 * A positive integer is magical if it is divisible by either A or B.
 * <p>
 * Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: N = 1, A = 2, B = 3
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: N = 4, A = 2, B = 3
 * Output: 6
 * <p>
 * Example 3:
 * <p>
 * Input: N = 5, A = 2, B = 4
 * Output: 10
 * <p>
 * Example 4:
 * <p>
 * Input: N = 3, A = 6, B = 4
 * Output: 8
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * 2 <= A <= 40000
 * 2 <= B <= 40000
 */
public class _878 {
    public int nthMagicalNumber(int N, int A, int B) {
        long low = 1, high = Long.MAX_VALUE;
        int M = 1000000007;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long aC = mid / A;
            long bC = mid / B;
            long cC = mid / (A * B / gcd(A, B));
            long count = aC + bC - cC;
            if (count >= N) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) (low % M);
    }

    private int gcd(int A, int B) {
        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
        }
        if (A % B == 0) {
            return B;
        } else {
            return gcd(B, A % B);
        }
    }
}
