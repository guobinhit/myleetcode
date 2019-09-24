package com.hit.basmath.learn.others;

/**
 * 745. Prefix and Suffix Search
 * <p>
 * Given many words, words[i] has weight i.
 * <p>
 * Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.
 * <p>
 * Examples:
 * <p>
 * Input:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // returns 0
 * WordFilter.f("b", "") // returns -1
 * <p>
 * Note:
 * <p>
 * 1. words has length in range [1, 15000].
 * 2. For each test case, up to words.length queries WordFilter.f may be made.
 * 3. words[i] has length in range [1, 10].
 * 4. prefix, suffix have lengths in range [0, 10].
 * 5. words[i] and prefix, suffix queries consist of lowercase letters only.
 */
public class _745 {
    class TrieNode {
        TrieNode[] children;
        int weight;

        public TrieNode() {
            children = new TrieNode[27]; // 'a' - 'z' and '{'. 'z' and '{' are neighbours in ASCII table
            weight = 0;
        }
    }

    class WordFilter {
        TrieNode root;

        public WordFilter(String[] words) {
            root = new TrieNode();
            for (int weight = 0; weight < words.length; weight++) {
                String word = words[weight] + "{";
                for (int i = 0; i < word.length(); i++) {
                    TrieNode cur = root;
                    cur.weight = weight;
                    // add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree
                    for (int j = i; j < 2 * word.length() - 1; j++) {
                        int k = word.charAt(j % word.length()) - 'a';
                        if (cur.children[k] == null)
                            cur.children[k] = new TrieNode();
                        cur = cur.children[k];
                        cur.weight = weight;
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            TrieNode cur = root;
            for (char c : (suffix + '{' + prefix).toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return -1;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.weight;
        }
    }
}
