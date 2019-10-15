package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 843. Guess the Word
 * <p>
 * This problem is an interactive problem new to the LeetCode platform.
 * <p>
 * We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.
 * <p>
 * You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the original list with 6 lowercase letters.
 * <p>
 * This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.
 * <p>
 * For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.
 * <p>
 * Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.
 * <p>
 * Example 1:
 * <p>
 * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 * <p>
 * Explanation:
 * <p>
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * <p>
 * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 * <p>
 * Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
 */
public class _843 {

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>(Arrays.asList(wordlist));
        // transfer String[] to list, so that we can remove item.
        for (int i = 0; i < 10; i++) {
            String s = list.get(0);
            int a = master.guess(s);
            // get the feedback and use it to shrink the range of candidates.
            if (a == s.length()) return;
            // if answer is right, stop this program.
            list.remove(0);
            // if answer is wrong, remove the guessed string because if we dont remove it, it will always meet the filter.
            int j = 0;
            // remove all items which have different answer with we guessed string, we should know that the correct answer can meet the filter all the time.
            while (j < list.size()) {
                if (compare(list.get(j), s) != a || (a == 0 && compare(list.get(j), s) > a)) {
                    list.remove(j);
                } else j++;
            }
            Collections.sort(list);
            //the final testcase need 11times....... use sort to be more lucky ^-^
        }

    }

    private int compare(String s1, String s2) {
        int ans = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) ans++;
        }
        return ans;
    }

    interface Master {
        public int guess(String word);
    }
}
