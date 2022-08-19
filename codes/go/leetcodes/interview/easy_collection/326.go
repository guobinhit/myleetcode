package easy_collection

/**
 * 326. Power of Three
 * <p>
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:
 * <p>
 * Input: 27
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: 0
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: 9
 * Output: true
 * <p>
 * Example 4:
 * <p>
 * Input: 45
 * Output: false
 * <p>
 * Follow up:
 * <p>
 * Could you do it without using any loop / recursion?
 */

func isPowerOfThree(n int) bool {
	if n < 1 {
		return false
	}
	for n%3 == 0 {
		n /= 3
	}
	return n == 1
}
