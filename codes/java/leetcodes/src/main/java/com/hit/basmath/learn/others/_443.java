package com.hit.basmath.learn.others;

/**
 * 443. String Compression
 * <p>
 * Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 * <p>
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["a","a","b","b","c","c","c"]
 * <p>
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * <p>
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["a"]
 * <p>
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * <p>
 * Explanation:
 * Nothing is replaced.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * <p>
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * <p>
 * Note:
 * <p>
 * 1. All characters have an ASCII value in [35, 126].
 * 2. 1 <= len(chars) <= 1000.
 */
public class _443 {
    public int compress(char[] chars) {

        if (chars == null || chars.length == 0)
            return 0;

        int index = 0, n = chars.length, i = 0;
        while (i < n) {
            char ch = chars[i];
            int j = i;
            while (j < n && chars[i] == chars[j]) { // chars[i..j - 1] are ch.
                j++;
            }
            int freq = j - i; // The frequency of ch.
            chars[index++] = ch;
            if (freq == 1) {

            } else if (freq < 10) {
                chars[index++] = (char) (freq + '0');
            } else {
                String strFreq = String.valueOf(freq);
                for (char chFreq : strFreq.toCharArray())
                    chars[index++] = chFreq;
            }
            i = j;
        }

        return index;
    }
}
