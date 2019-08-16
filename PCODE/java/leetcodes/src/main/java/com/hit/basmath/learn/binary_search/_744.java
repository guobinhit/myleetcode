package com.hit.basmath.learn.binary_search;

/**
 * 744. Find Smallest Letter Greater Than Target
 * <p>
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * <p>
 * Note:
 * 1. letters has a length in range [2, 10000].
 * 2. letters consists of lowercase letters, and contains at least 2 unique letters.
 * 3. target is a lowercase letter.
 */
public class _744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;

        if (target >= letters[length - 1]) {
            target = letters[0];
        } else {
            target++;
        }

        int left = 0, right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] == target)
                return letters[mid];

            if (letters[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[right];
    }
}
