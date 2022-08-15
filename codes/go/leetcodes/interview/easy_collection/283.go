package easy_collection

/**
 * 283. Move Zeroes
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * <p>
 * Output: [1,3,12,0,0]
 * <p>
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * <p>
 * Minimize the total number of operations.
 */

func moveZeroes(nums []int) []int {
	if len(nums) == 0 {
		return nums
	}
	nonZeroLength := 0
	for _, n := range nums {
		if n != 0 {
			nums[nonZeroLength] = n
			nonZeroLength++
		}
	}
	for ; nonZeroLength < len(nums); nonZeroLength++ {
		nums[nonZeroLength] = 0
	}
	return nums
}
