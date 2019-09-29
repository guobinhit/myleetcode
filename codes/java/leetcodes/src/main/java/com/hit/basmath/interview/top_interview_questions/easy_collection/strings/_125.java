package com.hit.basmath.interview.top_interview_questions.easy_collection.strings;

/**
 * 125. Valid Palindrome
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class _125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int head = 0, tail = s.length() - 1;
        char cHead, cTail;

        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
