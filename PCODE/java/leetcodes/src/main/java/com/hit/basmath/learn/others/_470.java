package com.hit.basmath.learn.others;

/**
 * 470. Implement Rand10() Using Rand7()
 * <p>
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
 * <p>
 * Do NOT use system's Math.random().
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: [7]
 * <p>
 * Example 2:
 * <p>
 * Input: 2
 * Output: [8,4]
 * <p>
 * Example 3:
 * <p>
 * Input: 3
 * Output: [8,1,10]
 */
public class _470 {
    class Solution extends SolBase {
        public int rand10() {
            int result = 40;
            while (result >= 40) {
                result = 7 * (rand7() - 1) + (rand7() - 1);
            }
            return result % 10 + 1;
        }
    }

    class SolBase {
        int rand7() {
            return 0;
        }
    }
}
