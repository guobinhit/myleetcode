package easy_collection

/**
 * 268. Missing Number
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * <p>
 * Note:
 * <p>
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

func missingNumber(nums []int) int {
	target := len(nums)
	for i, n := range nums {
		target ^= i ^ n

	}
	return target
}
