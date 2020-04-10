package com.hit.basmath.learn.others;

/**
 * 520. Detect Capital
 * <p>
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * <p>
 * Example 1:
 * <p>
 * Input: "USA"
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: "FlaG"
 * Output: False
 * <p>
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class _520 {
    public boolean detectCapitalUse(String word) {
        int numUpper = 0;
        for (int i = 0; i < word.length(); i++)
            if (Character.isUpperCase(word.charAt(i))) numUpper++;
        if (numUpper == 1) return Character.isUpperCase(word.charAt(0));
        return numUpper == 0 || numUpper == word.length();
    }

}
