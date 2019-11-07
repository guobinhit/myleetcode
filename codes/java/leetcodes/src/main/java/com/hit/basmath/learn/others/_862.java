package com.hit.basmath.learn.others;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 862. Shortest Subarray with Sum at Least K
 * <p>
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * <p>
 * If there is no non-empty subarray with sum at least K, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1], K = 1
 * Output: 1
 * Example 2:
 * <p>
 * Input: A = [1,2], K = 4
 * Output: -1
 * Example 3:
 * <p>
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */
public class _862 {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N + 1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList<>(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N + 1 ? ans : -1;
    }
}
