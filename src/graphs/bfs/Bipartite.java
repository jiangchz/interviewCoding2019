package graphs.bfs;

import graphs.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        HashMap<GraphNode, String> visited = new HashMap<>();
        for (GraphNode node : graph) {
            if (!bsf(node, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean bsf(GraphNode root, HashMap<GraphNode, String> visited) {
        if (visited.containsKey(root)) {
            return true;
        }

        LinkedList<GraphNode> toExplore = new LinkedList<>();
        String colorForNextGroup = "red";
        toExplore.add(root);
        int currentLevelSize = 1;

        while (!toExplore.isEmpty()) {
            GraphNode current = toExplore.removeFirst();
            List<GraphNode> neighbors = current.neighbors;
            for (GraphNode currentNeighbor : neighbors) {
                if (visited.containsKey(currentNeighbor) && visited.get(currentNeighbor) != colorForNextGroup) {
                    return false;
                } else if (visited.containsKey(currentNeighbor)) {
                    continue;
                }
                visited.put(currentNeighbor, colorForNextGroup);
                toExplore.add(currentNeighbor);
            }
            if(--currentLevelSize == 0) {
                colorForNextGroup = colorForNextGroup == "red" ? "blue" : "red";
                currentLevelSize = toExplore.size();
            }
        }
        return true;
    }
}

/*
    notes:
        use hashmap to store visited information
 */