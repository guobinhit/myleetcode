package easy_collection

/**
 * 189. Rotate Array
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * <p>
 * Output: [5,6,7,1,2,3,4]
 * <p>
 * Explanation:
 * <p>
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * <p>
 * Output: [3,99,-1,-100]
 * <p>
 * Explanation:
 * <p>
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * Could you do it in-place with O(1) extra space?
 */

func rotate189(nums []int, k int) {
	numsLength := len(nums)
	k %= numsLength
	if k > 0 {
		reverse189(nums, 0, numsLength-1)
		reverse189(nums, 0, k-1)
		reverse189(nums, k, numsLength-1)
	}
}

func reverse189(nums []int, left, right int) {
	for left < right {
		temp := nums[left]
		nums[left] = nums[right]
		nums[right] = temp
		left++
		right--
	}
}
