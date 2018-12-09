package com.hit.math.array_string;

/**
 * 557. Reverse Words in a String III
 * <p>
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * <p>
 * Input: "Let's take LeetCode contest"
 * <p>
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * <p>
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class _557 {
    public static String reverseWords(String s) {
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != ' ') {
                int j = i;
                /**
                 * If j + 1 < sChar.length && sChar[j + 1] != ' ' is true,
                 * it's mean this word is't the last word of s or complete,
                 * so let j++ until this condition is false
                 */
                while (j + 1 < sChar.length && sChar[j + 1] != ' ') {
                    j++;
                }
                /**
                 * reverse iterated word
                 */
                reverse(sChar, i, j);
                /**
                 * let i = j can shorten cycle times of j - i + 1
                 */
                i = j;
            }
        }
        return new String(sChar);
    }

    private static void reverse(char[] sChar, int i, int j) {
        while (i < j) {
            char tmp = sChar[i];
            sChar[i] = sChar[j];
            sChar[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
