package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 895. Maximum Frequency Stack
 * <p>
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 * <p>
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 * <p>
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 * The stack becomes [5,7,5,4].
 * <p>
 * pop() -> returns 5.
 * The stack becomes [5,7,4].
 * <p>
 * pop() -> returns 4.
 * The stack becomes [5,7].
 * <p>
 * Note:
 * <p>
 * Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
 * It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
 * The total number of FreqStack.push calls will not exceed 10000 in a single test case.
 * The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
 * The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.
 */
public class _895 {
    class FreqStack {

        List<Stack<Integer>> bucket;
        HashMap<Integer, Integer> map;

        public FreqStack() {
            bucket = new ArrayList<>();
            map = new HashMap<>();
        }

        public void push(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            int freq = map.get(x);
            if (freq - 1 >= bucket.size()) {
                bucket.add(new Stack<Integer>());
            }
            bucket.get(freq - 1).add(x);
        }

        public int pop() {
            int freq = bucket.size();
            int x = bucket.get(freq - 1).pop();
            if (bucket.get(freq - 1).isEmpty()) bucket.remove(bucket.size() - 1);

            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) map.remove(x);

            return x;
        }
    }
}
