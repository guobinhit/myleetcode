package easy_collection

/**
 * 234. Palindrome Linked List
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * <p>
 * Output: false
 * <p>
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * <p>
 * Output: true
 * <p>
 * Follow up:
 * <p>
 * Could you do it in O(n) time and O(1) space?
 */

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func isPalindrome(head *ListNode) bool {
	nums := make([]int, 0)
	for head != nil {
		nums = append(nums, head.Val)
		head = head.Next
	}
	left := 0
	right := len(nums) - 1
	for left <= right {
		if nums[left] != nums[right] {
			return false
		}
		left++
		right--
	}
	return true
}
