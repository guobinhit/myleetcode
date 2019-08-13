package com.hit.common;

/**
 * author:Charies Gavin
 * date:2019/8/13,18:09
 * https:github.com/guobinhit
 * description: Trie Array Node
 */
public class TrieArrayNode {
    public char val;
    public boolean isWord;
    public TrieArrayNode[] children;

    public TrieArrayNode() {
    }

    public TrieArrayNode(char val) {
        children = new TrieArrayNode[26];
        isWord = false;
        TrieArrayNode node = new TrieArrayNode();
        node.val = val;
    }
}
