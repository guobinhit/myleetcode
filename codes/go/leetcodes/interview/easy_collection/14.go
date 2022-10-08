package easy_collection

import "strings"

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * <p>
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	aimStr := strs[0]
	index := 1
	for index < len(strs) {
		for !strings.HasPrefix(strs[index], aimStr) {
			aimStr = aimStr[0 : len(aimStr)-1]
		}
		if len(aimStr) == 0 {
			return ""
		}
		index++
	}
	return aimStr
}
