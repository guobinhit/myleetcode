package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 884. Uncommon Words from Two Sentences
 * <p>
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Return a list of all uncommon words.
 * <p>
 * You may return the list in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * <p>
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class _884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        ArrayList<String> arr = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String AA : wordsA) {
            map.put(AA, map.getOrDefault(AA, 0) + 1);
        }
        for (String BB : wordsB) {
            map.put(BB, map.getOrDefault(BB, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= 1) {
                arr.add(entry.getKey());
            }
        }
        //Converting back from arraylist to array of string
        String[] l = new String[arr.size()];
        int itr = 0;
        for (String x : arr) {

            l[itr++] = x;
        }
        return l;
    }
}
