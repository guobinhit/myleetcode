package com.hit.basmath.learn.others;

import java.util.LinkedList;
import java.util.List;

/**
 * 890. Find and Replace Pattern
 * <p>
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 * <p>
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 * <p>
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 * <p>
 * Return a list of the words in words that match the given pattern.
 * <p>
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 */
public class _890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        for (String w : words) {
            int[] p = new int[26], s = new int[26];
            boolean same = true;
            for (int i = 0; i < w.length(); i++) {
                if (s[w.charAt(i) - 'a'] != p[pattern.charAt(i) - 'a']) {
                    same = false;
                    break;
                } else {
                    s[w.charAt(i) - 'a'] = p[pattern.charAt(i) - 'a'] = i + 1;
                }
            }
            if (same) res.add(w);
        }
        return res;
    }
}
