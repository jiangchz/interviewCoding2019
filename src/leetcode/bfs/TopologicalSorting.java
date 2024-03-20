package leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopologicalSorting {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        Map<DirectedGraphNode, Integer> inDegreeMap = createInDegreeMap(graph);
        bfs(graph, inDegreeMap, result);
        return result;
    }

    private void bfs(ArrayList<DirectedGraphNode> graph,
                     Map<DirectedGraphNode, Integer> inDegreeMap,
                     ArrayList<DirectedGraphNode> result) {
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode current : graph) {
            if (!inDegreeMap.containsKey(current)) {
                queue.offer(current);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode current = queue.poll();
            result.add(current);

            for(DirectedGraphNode neighbor : current.neighbors) {
                int inDegree = inDegreeMap.get(neighbor);
                if (inDegree == 1) {
                    queue.offer(neighbor);
                }
                inDegreeMap.put(neighbor, inDegree - 1);
            }
        }
        return;
    }

    private Map<DirectedGraphNode, Integer> createInDegreeMap(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();

        for (DirectedGraphNode current : graph) {
            for (DirectedGraphNode neighbor : current.neighbors) {
                if (!inDegreeMap.containsKey(neighbor)) {
                    inDegreeMap.put(neighbor, 1);
                } else {
                    inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) + 1);
                }

            }
        }
        return inDegreeMap;
    }

    class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    }
}
