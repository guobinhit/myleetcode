package com.hit.basmath.learn.others;

import java.util.*;

/**
 * 399. Evaluate Division
 * <p>
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above:
 * <p>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * <p>
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
public class _399 {
    Map<String, Map<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        if (equations == null || equations.size() == 0) return new double[0];
        if (values == null || values.length == 0) return new double[0];
        if (queries == null || queries.size() == 0) return new double[0];
        int n = queries.size();
        double result[] = new double[n];
        graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> eq = equations.get(i);
            graph.putIfAbsent(eq.get(0), new HashMap<String, Double>());
            graph.putIfAbsent(eq.get(1), new HashMap<String, Double>());
            graph.get(eq.get(0)).put(eq.get(1), values[i]);
            graph.get(eq.get(1)).put(eq.get(0), (1.0 / values[i]));
        }
        //System.out.println(graph);
        Set<String> visited = new HashSet<String>();
        for (int i = 0; i < n; i++) {

            List<String> query = queries.get(i);
            // if node is not present in Graph (Unreachable)
            if (graph.get(query.get(0)) == null || graph.get(query.get(1)) == null)
                result[i] = -1.0;
            else {
                visited.clear();
                visited.add(query.get(0));
                result[i] = dfs(query.get(0), query.get(1), visited);
            }
        }
        return result;
    }

    public Double dfs(String p1, String p2, Set<String> visited) {

        if (p1.equals(p2))
            return 1.0;
        double res;
        Map<String, Double> adjP1 = graph.get(p1);
        for (String key : adjP1.keySet()) {
            if (!visited.contains(key)) {
                visited.add(key);
                res = dfs(key, p2, visited);
                visited.remove(key);
                if (res != -1)
                    return adjP1.get(key) * res;
            }
        }
        return -1.0;
    }
}
