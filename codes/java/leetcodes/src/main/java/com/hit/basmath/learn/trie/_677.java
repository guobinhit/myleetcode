package com.hit.basmath.learn.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. Map Sum Pairs
 * <p>
 * Implement a MapSum class with insert, and sum methods.
 * <p>
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 * <p>
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 * <p>
 * Example 1:
 * <p>
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class _677 {
    class MapSum {
        class TrieNode {
            Map<Character, TrieNode> children;
            boolean isWord;
            int value;

            public TrieNode() {
                children = new HashMap<Character, TrieNode>();
                isWord = false;
                value = 0;
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode curr = root;
            for (char c : key.toCharArray()) {
                TrieNode next = curr.children.get(c);
                if (next == null) {
                    next = new TrieNode();
                    curr.children.put(c, next);
                }
                curr = next;
            }
            curr.isWord = true;
            curr.value = val;
        }

        public int sum(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                TrieNode next = curr.children.get(c);
                if (next == null) {
                    return 0;
                }
                curr = next;
            }

            return dfs(curr);
        }

        private int dfs(TrieNode root) {
            int sum = 0;
            for (char c : root.children.keySet()) {
                sum += dfs(root.children.get(c));
            }
            return sum + root.value;
        }
    }
}
