package com.hit.basmath.learn.recursion_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class _17 {

    /**
     * Solution method: Backtracking
     * <p>
     * Backtracking is an algorithm for finding all solutions by exploring all potential candidates.
     * If the solution candidate turns to be not a solution (or at least not the last one),
     * backtracking algorithm discards it by making some changes on the previous step,
     * i.e. backtracks and then try again.
     * <p>
     * Here is a backtrack function backtrack(combination, next_digits)
     * which takes as arguments an ongoing letter combination and the next digits to check.
     * <p>
     * If there is no more digits to check that means that the current combination is done.
     * If there are still digits to check :
     * -- Iterate over the letters mapping the next available digit.
     * -- -- Append the current letter to the current combination combination = combination + letter.
     * -- -- Proceed to check next digits : backtrack(combination + letter, next_digits[1:]).
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity : O(3^N * 4^M) where N is the number of digits in the input that
     * maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that
     * maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.
     * <p>
     * Space complexity : O(3^N * 4^M) since one has to keep 3^N * 4^M solutions.
     */
    private Map<String, String> phone = new HashMap<String, String>() {
        private static final long serialVersionUID = -7378083213511974320L;

        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    private List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    private List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}
