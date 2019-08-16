package com.hit.basmath.learn.array_and_string;

/**
 * 28. Implement strStr()
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class _28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        /**
         * When needleLength <= haystackLength,
         * the largest aim index of haystack is haystackLength - needleLength + 1
         * so, the largest circle times is haystackLength - needleLength + 1
         *
         * When needleLength > haystackLength, return -1 immediately
         */
        for (int i = 0; i < haystackLength - needleLength + 1; i++) {
            int count = 0;
            /**
             * The largest circle times of this while-circle is needleLength,
             * and in this needleLength times circle,
             * if haystack.charAt(i + count) == needle.charAt(count) just right n times,
             * then count = needleLength, thus i is the aim index
             */
            while (count < needleLength && haystack.charAt(i + count) == needle.charAt(count)) {
                count++;
            }
            if (count == needleLength) {
                return i;
            }
        }
        return -1;
    }

    /**
     * It's a excellent methods
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

    /**
     * This is a good way to solve this question, but it used build-in function,
     * and on interview we should't use build-in function
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        int haystackLength = haystack.length(), needleLength = needle.length();
        if (haystackLength < needleLength) {
            return -1;
        } else if (needleLength == 0) {
            return 0;
        }
        int threshold = haystackLength - needleLength;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Be like strStr3, this way is more straightforward, just a joking
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr4(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
