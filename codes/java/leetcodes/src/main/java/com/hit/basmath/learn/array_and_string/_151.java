package com.hit.basmath.learn.array_and_string;

/**
 * 151. Reverse Words in a String
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Input: "the sky is blue",
 * <p>
 * Output: "blue is sky the".
 * <p>
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
public class _151 {
    public static String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder("");
        /**
         * Iterate i from parts.length - 1 to 1
         */
        for (int i = parts.length - 1; i > 0; i--) {
            sb.append(parts[i] + " ");
        }
        /**
         * Because above for loop don't contain parts[0],
         * so we should add parts[0] before result return
         */
        return sb.toString() + parts[0];
    }

    public static String reverseWords2(String s) {
        /**
         * reverse the whole string and convert to char array
         */
        char[] str = reverse(s.toCharArray(), 0, s.length() - 1);
        /**
         * start and end positions of a current word
         */
        int start = 0, end = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') { //
                /**
                 * If the current char is letter,
                 * just move this letter to the next free pos
                 */
                str[end++] = str[i]; //
            } else if (i > 0 && str[i - 1] != ' ') {
                /**
                 * If the first space after word, reverse the word
                 */
                reverse(str, start, end - 1);
                str[end++] = ' '; // and put the space after it
                start = end; // move start position further for the next word
            }
        }
        reverse(str, start, end - 1); // reverse the tail word if it's there
        // here's an ugly return just because we need to return Java's String
        // also as there could be spaces at the end of original string
        // we need to consider redundant space we have put there before
        return new String(str, 0, end > 0 && str[end - 1] == ' ' ? end - 1 : end);
    }

    // reverses the part of an array and returns the input array for convenience
    private static char[] reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
    }
}
