package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 332. Reconstruct Itinerary
 * <p>
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * 1. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * 2. All airports are represented by three capital letters (IATA code).
 * 3. You may assume all tickets form at least one valid itinerary.
 * <p>
 * Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * <p>
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * <p>
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class _332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {
            if (!map.containsKey(tickets.get(i).get(0))) {
                map.put(tickets.get(i).get(0), new PriorityQueue<String>());
                map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            } else {
                map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            }
        }

        String curr = "JFK";

        dfs(result, map, curr);

        return result;
    }

    private void dfs(List<String> result, HashMap<String, PriorityQueue<String>> map, String curr) {
        while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
            String s = map.get(curr).poll();
            dfs(result, map, s);
        }
        result.add(0, curr);
    }
}
