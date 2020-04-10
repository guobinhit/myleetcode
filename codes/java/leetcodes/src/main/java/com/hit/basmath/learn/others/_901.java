package com.hit.basmath.learn.others;

/**
 * 901. Online Stock Span
 * <p>
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 * <p>
 * Example 1:
 * <p>
 * Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 * <p>
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 * <p>
 * Note:
 * <p>
 * Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
 * There will be at most 10000 calls to StockSpanner.next per test case.
 * There will be at most 150000 calls to StockSpanner.next across all test cases.
 * The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */
public class _901 {
    class StockSpanner {
        int size;
        int[] arr;
        int[] map;

        public StockSpanner() {
            arr = new int[10000];
            map = new int[10000];
            size = 0;
        }

        public int next(int price) {
            arr[size++] = price;
            int ret = 1;
            if (size == 1) {
                map[size - 1] = 1;
                return 1;
            }
            int tmp = size - 1;
            while (tmp > 0 && arr[tmp - 1] <= price) {
                ret += map[tmp - 1];
                tmp = tmp - map[tmp - 1];
            }
            map[size - 1] = ret;
            return ret;
        }
    }
}
