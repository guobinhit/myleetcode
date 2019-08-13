package com.hit.math.trie;

import com.hit.common.TrieArrayNode;

/**
 * 208. Implement Trie (Prefix Tree)
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * <p>
 * Note:
 * <p>
 * 1. You may assume that all inputs are consist of lowercase letters a-z.
 * 2. All inputs are guaranteed to be non-empty strings.
 */
public class _208 {
    class Trie {
        private TrieArrayNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieArrayNode();
            root.val = ' ';
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieArrayNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    ws.children[c - 'a'] = new TrieArrayNode(c);
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieArrayNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null)
                    return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieArrayNode ws = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (ws.children[c - 'a'] == null)
                    return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }
    }
}
