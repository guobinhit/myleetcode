package easy_collection

/**
 * 204. Count Primes
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */

func countPrimes(n int) int {
	count := 0
	notPrime := make([]bool, n)
	for i := 2; i < n; i++ {
		if !notPrime[i] {
			count++
			for j := 2; j*i < n; j++ {
				notPrime[j*i] = true
			}
		}

	}
	return count
}
