package easy_collection

/**
 * 1. Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * <p>
 * return [0, 1].
 */

func twoSum(nums []int, target int) []int {
	if len(nums) < 1 {
		return []int{}
	}

	numAndIndexMap := make(map[int]int)
	for i, n := range nums {
		remain := target - n
		if index, ok := numAndIndexMap[remain]; ok {
			return []int{index, i}
		}
		numAndIndexMap[n] = i
	}
	return []int{}
}
