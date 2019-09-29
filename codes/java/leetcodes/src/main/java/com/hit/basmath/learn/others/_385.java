package com.hit.basmath.learn.others;

import java.util.List;
import java.util.Stack;

/**
 * 385. Mini Parser
 * <p>
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Note: You may assume that the string is well-formed:
 * <p>
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * <p>
 * Example 1:
 * <p>
 * Given s = "324",
 * <p>
 * You should return a NestedInteger object which contains a single integer 324.
 * <p>
 * Example 2:
 * <p>
 * Given s = "[123,[456,[789]]]",
 * <p>
 * Return a NestedInteger object containing a nested list with 2 elements:
 * <p>
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * i.  An integer containing value 456.
 * ii. A nested list with one element:
 * a. An integer containing value 789.
 */
public class _385 {

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * // Constructor initializes an empty nested list.
     * public NestedInteger();
     * <p>
     * // Constructor initializes a single integer.
     * public NestedInteger(int value);
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // Set this NestedInteger to hold a single integer.
     * public void setInteger(int value);
     * <p>
     * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     * public void add(NestedInteger ni);
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public NestedInteger deserialize(String s) {
        if (s.isEmpty())
            return null;
        if (s.charAt(0) != '[') // ERROR: special case
            return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0; // l shall point to the start of a number substring;
        // r shall point to the end+1 of a number substring
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r + 1;
            } else if (ch == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty())
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r + 1;
            } else if (ch == ',') {
                if (s.charAt(r - 1) != ']') {
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = r + 1;
            }
        }

        return curr;
    }


    class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }


        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }


        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }
}


