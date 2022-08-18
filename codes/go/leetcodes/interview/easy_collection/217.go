package easy_collection

/**
 * 217. Contains Duplicate
 * <p>
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

func containsDuplicate(nums []int) bool {
	aMap := make(map[int]struct{})
	for _, n := range nums {
		if _, ok := aMap[n]; ok {
			return true
		}
		aMap[n] = struct{}{}
	}
	return false
}
