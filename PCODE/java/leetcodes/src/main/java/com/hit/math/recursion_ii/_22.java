package com.hit.math.recursion_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class _22 {

    /**
     * Approach 1: Brute Force
     * <p>
     * Intuition:
     * <p>
     * We can generate all 2^(2n) sequences of '(' and ')' characters.
     * Then, we will check if each one is valid.
     * <p>
     * Algorithm:
     * <p>
     * To generate all sequences, we use a recursion. All sequences of length n is
     * just '(' plus all sequences of length n-1, and then ')' plus all sequences of length n-1.
     * <p>
     * To check whether a sequence is valid, we keep track of balance,
     * the net number of opening brackets minus closing brackets.
     * If it falls below zero at any time, or doesn't end in zero,
     * the sequence is invalid - otherwise it is valid.
     *
     * @param n seed number
     * @return result list
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    /**
     * Approach 2: Backtracking
     * <p>
     * Intuition and Algorithm:
     * <p>
     * Instead of adding '(' or ')' every time as in Approach 1,
     * let's only add them when we know it will remain a valid sequence.
     * We can do this by keeping track of the number of opening and closing brackets
     * we have placed so far.
     * <p>
     * We can start an opening bracket if we still have one (of n) left to place.
     * And we can start a closing bracket if it would not exceed the number of opening brackets.
     *
     * @param n seed number
     * @return result list
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }


    /**
     * Approach 3: Closure Number
     * <p>
     * Intuition:
     * <p>
     * To enumerate something, generally we would like to express
     * it as a sum of disjoint subsets that are easier to count.
     * <p>
     * Consider the closure number of a valid parentheses sequence S:
     * the least index >= 0 so that S[0], S[1], ..., S[2*index+1] is valid.
     * Clearly, every parentheses sequence has a unique closure number.
     * We can try to enumerate them individually.
     * <p>
     * Algorithm:
     * <p>
     * For each closure number c, we know the starting and ending brackets must be
     * at index 0 and 2*c + 1. Then, the 2*c elements between must be a valid sequence,
     * plus the rest of the elements must be a valid sequence.
     *
     * @param n seed number
     * @return result list
     */
    public List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis3(c))
                    for (String right : generateParenthesis3(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
