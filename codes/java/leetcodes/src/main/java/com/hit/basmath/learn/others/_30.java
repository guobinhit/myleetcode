package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * <p>
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * <p>
 * Output: [0,9]
 * <p>
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * <p>
 * Output: []
 */
public class _30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0) return res;
        int len = words[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<String, Integer>(); // map for words
        for (String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < words.length; j++) { // checkc if match
                String str = s.substring(i + j * len, i + j * len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in words
            }
        }
        return res;
    }
}
