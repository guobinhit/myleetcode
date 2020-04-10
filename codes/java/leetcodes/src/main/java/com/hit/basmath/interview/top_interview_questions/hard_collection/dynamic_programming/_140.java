package com.hit.basmath.interview.top_interview_questions.hard_collection.dynamic_programming;

import java.util.*;

/**
 * 140. Word Break II
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * <p>
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * <p>
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * <p>
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * <p>
 * Output:
 * []
 */
public class _140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> word = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> memo = new HashMap<>(); // <Starting index, rst list>
        return dfs(s, 0, word, memo);
    }

    private List<String> dfs(String s, int start, Set<String> dict, HashMap<Integer, List<String>> memo) {
        if (memo.containsKey(start))
            return memo.get(start);

        List<String> rst = new ArrayList<>();
        if (start == s.length()) {
            rst.add("");
            return rst;
        }
        String curr = s.substring(start);
        for (String word : dict) {
            if (curr.startsWith(word)) {
                List<String> sublist = dfs(s, start + word.length(), dict, memo);
                for (String sub : sublist) {
                    rst.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        memo.put(start, rst);
        return rst;
    }
}
