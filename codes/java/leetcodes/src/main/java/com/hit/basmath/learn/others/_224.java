package com.hit.basmath.learn.others;

import java.util.Stack;

/**
 * 224. Basic Calculator
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * Example 1:
 * <p>
 * Input: "1 + 1"
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: " 2-1 + 2 "
 * Output: 3
 * <p>
 * Example 3:
 * <p>
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * <p>
 * Note:
 * <p>
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class _224 {
    public static int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }
}
