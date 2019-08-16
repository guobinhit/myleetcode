package com.hit.basmath.learn.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 336. Palindrome Pairs
 * <p>
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * <p>
 * Example 2:
 * <p>
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */
public class _336 {
    private Node root;

    public List<List<Integer>> palindromePairs(String[] words) {

        if (words == null || words.length == 0)
            return new ArrayList<>();

        root = new Node();
        int n = words.length;
        List<List<Integer>> finalResult = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (words[i].isEmpty()) {
                // Pair with all self-palindrome.
                List<Integer> selfPalindromeWordIndices = getSelfPalindrome(words);
                for (int pairId : selfPalindromeWordIndices) {
                    finalResult.add(new ArrayList<>(Arrays.asList(i, pairId)));
                    finalResult.add(new ArrayList<>(Arrays.asList(pairId, i)));
                }
            } else {
                insert(reverse(words[i]), i);
            }
        }
        for (int i = 0; i < n; i++) {
            List<Integer> wordIndices = search(words[i], i);
            for (int pairId : wordIndices) {
                finalResult.add(new ArrayList<>(Arrays.asList(i, pairId)));
            }
        }

        return finalResult;
    }

    /****************** Trie-related *******************/

    private List<Integer> search(String word, int index) {

        List<Integer> wordIndices = new ArrayList<>();
        Node ptr = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int label = word.charAt(i) - 'a';
            if (ptr.endWordId > -1 && isPalindrome(word, i, n - 1)) {
                wordIndices.add(ptr.endWordId);
            }
            if (ptr.children[label] == null) {
                return wordIndices;
            }
            ptr = ptr.children[label];
        }
        if (ptr.endWordId > -1 && ptr.endWordId != index)
            wordIndices.add(ptr.endWordId);
        if (!ptr.belowPalindromeWordIds.isEmpty())
            wordIndices.addAll(ptr.belowPalindromeWordIds);

        return wordIndices;
    }

    private void insert(String word, int index) {

        Node ptr = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int label = word.charAt(i) - 'a';
            if (ptr.children[label] == null)
                ptr.children[label] = new Node();
            ptr = ptr.children[label];
            if (isPalindrome(word, i + 1, n - 1))
                ptr.belowPalindromeWordIds.add(index);
        }

        ptr.endWordId = index;
    }

    class Node {

        Node[] children;
        int endWordId; // Equals to -1 in default. If it is a word's end, it is the index of the word.
        List<Integer> belowPalindromeWordIds; // List of word indices such that nodes below can construct a palindrome.

        public Node() {
            children = new Node[26];
            endWordId = -1;
            belowPalindromeWordIds = new ArrayList<>();
        }

    }

    /****************** Utility *******************/

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private boolean isPalindrome(String str, int start, int end) {

        if (start > end) {
            return false;
        }

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

    private List<Integer> getSelfPalindrome(String[] words) {
        List<Integer> wordIndices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i], 0, words[i].length() - 1)) {
                wordIndices.add(i);
            }
        }
        return wordIndices;
    }
}
