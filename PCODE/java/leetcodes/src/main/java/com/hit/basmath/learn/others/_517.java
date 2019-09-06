package com.hit.basmath.learn.others;

/**
 * 517. Super Washing Machines
 * <p>
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 * <p>
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .
 * <p>
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.
 * <p>
 * Example1
 * <p>
 * Input: [1,0,5]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * 1st move:    1     0 <-- 5    =>    1     1     4
 * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
 * 3rd move:    2     1 <-- 3    =>    2     2     2
 * <p>
 * Example2
 * <p>
 * Input: [0,3,0]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * 1st move:    0 <-- 3     0    =>    1     2     0
 * 2nd move:    1     2 --> 0    =>    1     1     1
 * <p>
 * Example3
 * <p>
 * Input: [0,2,0]
 * <p>
 * Output: -1
 * <p>
 * Explanation:
 * <p>
 * It's impossible to make all the three washing machines have the same number of dresses.
 * <p>
 * Note:
 * <p>
 * 1. The range of n is [1, 10000].
 * 2. The range of dresses number in a super washing machine is [0, 1e5].
 */
public class _517 {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int i : machines) total += i;
        if (total % machines.length != 0) return -1;
        int avg = total / machines.length, cnt = 0, max = 0;
        for (int load : machines) {
            cnt += load - avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
        }
        return max;
    }
}
