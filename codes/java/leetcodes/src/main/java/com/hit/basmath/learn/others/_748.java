package com.hit.basmath.learn.others;

/**
 * 748. Shortest Completing Word
 * <p>
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate
 * <p>
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * <p>
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 * <p>
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 * <p>
 * Example 1:
 * <p>
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * <p>
 * Example 2:
 * <p>
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * <p>
 * Note:
 * <p>
 * 1. licensePlate will be a string with length in range [1, 7].
 * 2. licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * 3. words will have a length in the range [10, 1000].
 * 4. Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class _748 {
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

    public String shortestCompletingWord(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
        for (String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                shortest = word;
        return shortest;
    }

    private long getCharProduct(String plate) {
        long product = 1L;
        for (char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25)
                product *= primes[index];
        }
        return product;
    }
}
