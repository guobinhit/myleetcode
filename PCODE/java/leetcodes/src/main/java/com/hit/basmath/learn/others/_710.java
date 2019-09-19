package com.hit.basmath.learn.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 710. Random Pick with Blacklist
 * <p>
 * Given a blacklist B containing unique integers from [0, N), write a function to return a uniform random integer from [0, N) which is NOT in B.
 * <p>
 * Optimize it such that it minimizes the call to system’s Math.random().
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N) does NOT include N. See interval notation.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * Output: [null,0,0,0]
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * Output: [null,1,1,1]
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 * <p>
 * Example 4:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * Output: [null,1,3,1]
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has two arguments, N and the blacklist B. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class _710 {
    class Solution {

        // N: [0, N)
        // B: blacklist
        // B1: < N
        // B2: >= N
        // M: N - B1
        private int M;
        private Random r;
        Map<Integer, Integer> map;

        public Solution(int N, int[] blacklist) {
            map = new HashMap();
            for (int b : blacklist) // O(B)
                map.put(b, -1);
            M = N - map.size();

            for (int b : blacklist) { // O(B)
                if (b < M) { // re-mapping
                    while (map.containsKey(N - 1))
                        N--;
                    map.put(b, N - 1);
                    N--;
                }
            }

            r = new Random();
        }

        public int pick() {
            int p = r.nextInt(M);
            if (map.containsKey(p))
                return map.get(p);
            return p;
        }
    }
}
