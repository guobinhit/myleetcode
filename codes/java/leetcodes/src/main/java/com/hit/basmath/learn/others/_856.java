package com.hit.basmath.learn.others;

import java.util.Stack;

/**
 * 856. Score of Parentheses
 * <p>
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: "(())"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: 2
 * <p>
 * Example 4:
 * <p>
 * Input: "(()(()))"
 * Output: 6
 * <p>
 * Note:
 * <p>
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 */
public class _856 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                int cur = 0;
                while (stack.peek() != -1) {
                    cur += stack.pop();
                }
                stack.pop();
                stack.push(cur == 0 ? 1 : cur * 2);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
