package com.hit.basmath.learn.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 820. Short Encoding of Words
 * <p>
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 * <p>
 * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
 * <p>
 * Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.
 * <p>
 * What is the length of the shortest reference string S possible that encodes the given words?
 * <p>
 * Example:
 * <p>
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 2000.
 * 1 <= words[i].length <= 7.
 * Each word has only lowercase letters.
 */
public class _820 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String w : words)
            for (int i = 1; i < w.length(); ++i)
                s.remove(w.substring(i));
        int res = 0;
        for (String w : s) res += w.length() + 1;
        return res;
    }
}
