package easy_collection

/**
 * 7. Reverse Integer
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * <p>
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */

func reverse(x int) int {
	maxInt := int(^uint32(0)>>1) - 1
	minInt := ^int(^uint32(0)>>1) + 1
	ans := 0
	for x != 0 {
		pop := x % 10
		x = x / 10
		if ans > maxInt/10 || (ans == maxInt/10 && pop > 7) {
			return 0
		}
		if ans < minInt/10 || (ans == minInt/10 && pop < -8) {
			return 0
		}
		ans = ans*10 + pop
	}
	return ans
}
