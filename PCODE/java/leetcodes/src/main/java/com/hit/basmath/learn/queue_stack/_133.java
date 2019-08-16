package com.hit.basmath.learn.queue_stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. Clone Graph
 * <p>
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * <p>
 * Example:
 * <p>
 * Input: {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * <p>
 * Explanation:
 * <p>
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 * <p>
 * Note:
 * <p>
 * 1. The number of nodes will be between 1 and 100.
 * 2. The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * 3. Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * 4. You must return the copy of the given node as a reference to the cloned graph.
 */
public class _133 {

    public Node cloneGraph(Node node) {
        if (node == null) return node;

        return clone(node, new HashMap<Node, Node>());
    }

    private Node clone(Node original, Map<Node, Node> clones) {
        if (clones.containsKey(original)) return clones.get(original);

        clones.put(original, new Node(original.val, new ArrayList<>()));

        if (original.neighbors != null) {
            for (Node n : original.neighbors)
                clones.get(original).neighbors.add(clone(n, clones));
        }

        return clones.get(original);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
