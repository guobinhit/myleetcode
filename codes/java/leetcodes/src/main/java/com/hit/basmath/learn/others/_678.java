package com.hit.basmath.learn.others;

/**
 * 678. Valid Parenthesis String
 * <p>
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: "(*)"
 * Output: True
 * <p>
 * Example 3:
 * <p>
 * Input: "(*))"
 * Output: True
 * <p>
 * Note: The string size will be in the range [1, 100].
 */
public class _678 {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}
