package easy_collection

/**
 * 136. Single Number
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */

func singleNumber(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	ans := nums[0]
	for i, n := range nums {
		if i != 0 {
			ans ^= n
		}
	}
	return ans
}
