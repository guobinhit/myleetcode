package com.hit.basmath.learn.others;

import java.util.ArrayList;

/**
 * 500. Keyboard Row
 * <p>
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * <p>
 * Example:
 * <p>
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * <p>
 * Note:
 * <p>
 * 1. You may use one character in the keyboard more than once.
 * 2. You may assume the input string will only contain letters of alphabet.
 */
public class _500 {
    private String[] rows = new String[]{"QWERTYUIOPqwertyuiop", "ASDFGHJKLasdfghjkl", "ZXCVBNMzxcvbnm"};

    public String[] findWords(String[] words) {
        ArrayList<String> result = new ArrayList<String>();

        int currentRow = 0;
        boolean found = true;
        for (String s : words) {
            currentRow = getCurrentRow(s.charAt(0));
            found = true;
            for (char c : s.toCharArray()) {
                if (rows[currentRow].indexOf(c) == -1) {
                    found = false;
                    break;
                }
            }
            if (found)
                result.add(s);
        }

        return result.toArray(new String[result.size()]);
    }

    private int getCurrentRow(char c) {
        for (int rowNumber = 0; rowNumber < 3; rowNumber++) {
            if (rows[rowNumber].indexOf(c) != -1) {
                return rowNumber;
            }
        }
        return -1;
    }
}
