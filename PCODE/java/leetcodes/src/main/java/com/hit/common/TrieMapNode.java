package com.hit.common;

import java.util.HashMap;
import java.util.Map;

/**
 * author:Charies Gavin
 * date:2019/8/13,18:14
 * https:github.com/guobinhit
 * description: Trie Map Node
 */
public class TrieMapNode {
    public Map<Character, TrieMapNode> children;
    public boolean isWord;
    public int value;

    public TrieMapNode() {
        children = new HashMap<Character, TrieMapNode>();
        isWord = false;
        value = 0;
    }
}
