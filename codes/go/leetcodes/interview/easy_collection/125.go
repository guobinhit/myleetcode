package easy_collection

import "strings"

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

func isPalindrome125(s string) bool {
	var sb strings.Builder
	s = strings.ToLower(s)
	for _, ch := range s {
		if (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') {
			sb.WriteString(string(ch))
		}
	}
	i := 0
	j := len(sb.String()) - 1
	s = sb.String()
	for i <= j {
		if s[i] != s[j] {
			return false
		}
		i += 1
		j -= 1
	}
	return true
}
