package com.hit.basmath.learn.hash_table;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 * <p>
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * <p>
 * Output: ["Shogun"]
 * <p>
 * Explanation: The only restaurant they both like is "Shogun".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * <p>
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * <p>
 * Output: ["Shogun"]
 * <p>
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * <p>
 * Note:
 * <p>
 * 1. The length of both lists will be in the range of [1, 1000].
 * 2. The length of strings in both lists will be in the range of [1, 30].
 * 3. The index is starting from 0 to the list length minus 1.
 * 4. No duplicates in both lists.
 */
public class _599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) {
                    res.clear();
                    minSum = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
