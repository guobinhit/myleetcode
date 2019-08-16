package com.hit.basmath.learn.array_string;

/**
 * 344. Reverse String
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "olleh"
 * <p>
 * Example 2:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class _344 {
    public String reverseString(String s) {
        /**
         * If s is null or s.length() == 0 is true,
         * we can return s immediately
         */
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] sChars = s.toCharArray();
        int j = sChars.length - 1;
        /**
         * Declaring variables here can achieve the purpose of multiplexing
         */
        char tempChar;
        /**
         * Let i++ in for loop, can reduce one times self increase

         */
        for (int i = 0; i < j; i++) {
            /**
             * In for loop, i < j can be true, but when i self increased,
             * i < j can be false, it's mean element reach middle
             */
            if (i < j) {
                tempChar = sChars[i];
                sChars[i] = sChars[j];
                sChars[j] = tempChar;
                j--;
            }
        }
        return new String(sChars);
    }
}
