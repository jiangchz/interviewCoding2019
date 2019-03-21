package graphsAndSearch.bfs;

import java.util.*;

public class CloneGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        Map<GraphNode, GraphNode> nodeMapping = new HashMap<>();
        Set<GraphNode> explored = new HashSet<>();
        Queue<GraphNode> toExplore = new LinkedList<>();
        List<GraphNode> newGraph = new ArrayList<>();

        for (GraphNode current : graph) {
            if (!explored.contains(current)) {
                toExplore.offer(current);
                while (!toExplore.isEmpty()) {
                    GraphNode toExploreNode = toExplore.poll();
                    GraphNode copyNode = new GraphNode(toExploreNode.key);
                    nodeMapping.put(toExploreNode, copyNode);
                    explored.add(toExploreNode);

                    for (GraphNode neighbor : toExploreNode.neighbors) {
                        if (!explored.contains(neighbor)) {
                            toExplore.offer(neighbor);
                            GraphNode copyNeighborNode = new GraphNode(neighbor.key);
                            nodeMapping.put(neighbor, copyNeighborNode);
                        }
                        copyNode.neighbors.add(nodeMapping.get(neighbor));
                    }
                }
            }
            newGraph.add(nodeMapping.get(current));
        }
        return newGraph;
    }
    public  class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
     this.key = key;
     this.neighbors = new ArrayList<GraphNode>();
   }
 }
}

/*
搞清楚这2套api，
	        Throws exception	Returns special value
    Insert	add(e)	            offer(e)
    Remove	remove()	        poll()
    Examine	element()	        peek()

bfs的时候需要用到queue：
            Queue<GraphNode> toExplore = new LinkedList<>();
酸爽。。。。
 */
