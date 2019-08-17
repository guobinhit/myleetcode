package com.hit.basmath.interview.top_interview_questions.hard_collection.trees_and_graphs;

import java.util.*;

/**
 * 127. Word Ladder
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * <p>
 * Note:
 * <p>
 * 1. Return 0 if there is no such transformation sequence.
 * 2. All words have the same length.
 * 3. All words contain only lowercase alphabetic characters.
 * 4. You may assume no duplicates in the word list.
 * 5. You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class _127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        Set<String> set = new HashSet<>(wordList);

        // Make sure we can reach the endWord
        if (!set.contains(endWord)) return 0;

        // Add beginning word
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            // Go through each level BFS
            int size = queue.size();
            level++;
            while (size > 0) {
                size--;

                // Take out the word from the queue
                String currentWord = queue.poll();

                // Remove the word from the wordList. We don't need it anymore
                if (set.contains(currentWord)) set.remove(currentWord);

                // If it is the same word, then we have the current level
                if (currentWord.equals(endWord)) return level;

                // Add the next level of words to the queue
                addWordToQueue(queue, set, currentWord);
            }
        }

        // If we don't find it, then there is no level to reach it
        return 0;
    }

    private void addWordToQueue(Queue<String> queue, Set<String> set, String word) {
        // We don't want duplicate words
        Set<String> wordsInDict = new HashSet<>();

        // Going through the word, transform it.
        for (int i = 0; i < word.length(); i++) {
            // For [a-z] characters
            for (int j = 0; j < 26; j++) {
                // This transforms the character
                // example: hot -> *ot, h*t, ho*
                // the * is characters [a-z]
                String newWord = word.substring(0, i) + ((char) (((int) 'a') + j)) + word.substring(i + 1, word.length());

                // We the new word exists in the wordList
                if (set.contains(newWord)) {
                    // Add the new word to the list to be added to the queue at the end of this function
                    wordsInDict.add(newWord);

                    // Remove the newWord from our set because we don't need it anymore because it will be added to the queue
                    set.remove(newWord);
                }
            }
        }

        // Transfer the non duplicate newly generated word list
        queue.addAll(wordsInDict);
    }
}
