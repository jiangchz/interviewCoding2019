package leetcode.graphsAndSearch;

import java.util.*;

public class CloneGraph_LC133 {
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return node;
        }

        Map<GraphNode, GraphNode> nodeMapping = new HashMap<>();
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> toVisit = new LinkedList<>();

        toVisit.offer(node);

        while(!toVisit.isEmpty()) {
            GraphNode current = toVisit.poll();
            if (visited.contains(current)) {
                continue;
            }

            nodeMapping.putIfAbsent(current, new GraphNode(current.value, new ArrayList<>()));
            GraphNode currentCopy = nodeMapping.get(current);
            List<GraphNode> copyNeighbors = currentCopy.neighbors;
            for (GraphNode neighbor : current.neighbors) {
                nodeMapping.putIfAbsent(neighbor, new GraphNode(neighbor.value, new ArrayList<>()));
                GraphNode copyNeighbor = nodeMapping.get(neighbor);
                copyNeighbors.add(copyNeighbor);
                toVisit.offer(neighbor);
            }

            visited.add(current);
        }

        return nodeMapping.get(node);

    }
}
