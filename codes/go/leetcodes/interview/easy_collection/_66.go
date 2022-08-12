package easy_collection

/**
 * 66. Plus One
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * <p>
 * Example 3:
 * <p>
 * Input: [9,9]
 * Output: [1,0,0]
 * Explanation: The array represents the integer 99.
 */

func plusOne(digits []int) []int {
	digits = reverse(digits)
	for i, n := range digits {
		if n+1 <= 9 {
			digits[i] = n + 1
			digits = reverse(digits)
			return digits
		}
		digits[i] = 0
	}
	digits = append(digits, 1)
	digits = reverse(digits)
	return digits
}

func reverse(digits []int) []int {
	newDigits := make([]int, 0)
	digitsLen := len(digits)
	for digitsLen > 0 {
		digitsLen--
		newDigits = append(newDigits, digits[digitsLen])
	}
	return newDigits
}
