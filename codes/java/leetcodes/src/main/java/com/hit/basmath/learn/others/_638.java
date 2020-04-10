package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 638. Shopping Offers
 * <p>
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.
 * <p>
 * However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.
 * <p>
 * You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.
 * <p>
 * Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.
 * <p>
 * You could use any of special offers as many times as you want.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * Output: 14
 * <p>
 * Explanation:
 * There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
 * In special offer 1, you can pay $5 for 3A and 0B
 * In special offer 2, you can pay $10 for 1A and 2B.
 * You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 * <p>
 * Example 2:
 * <p>
 * Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * Output: 11
 * <p>
 * Explanation:
 * The price of A is $2, and $3 for B, $4 for C.
 * You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
 * You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
 * You cannot add more items, though only $9 for 2A ,2B and 1C.
 * <p>
 * Note:
 * <p>
 * There are at most 6 kinds of items, 100 special offers.
 * For each item, you need to buy at most 6 of them.
 * You are not allowed to buy more items than you want, even if that would lower the overall price.
 */
public class _638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);
    }

    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int local_min = directPurchase(price, needs);
        for (int i = pos; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < offer.get(j)) { // check if the current offer is valid
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - offer.get(j));
            }

            if (temp != null) { // use the current offer and try next
                local_min = Math.min(local_min, offer.get(offer.size() - 1) + helper(price, special, temp, i));
            }
        }

        return local_min;
    }

    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += price.get(i) * needs.get(i);
        }

        return total;
    }
}
