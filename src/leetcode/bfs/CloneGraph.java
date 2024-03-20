package leetcode.bfs;

import java.util.*;

public class CloneGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        Set<GraphNode> expanded = new HashSet<>();
        List<GraphNode> copiedGraph = new ArrayList<>();
        Queue<GraphNode> toExpandNodes = new LinkedList<>();
        Map<GraphNode, GraphNode> nodeMapping = new HashMap<>();

        for (GraphNode currentNode : graph) {
            if (!expanded.contains(currentNode)) {
                toExpandNodes.offer(currentNode);
                GraphNode currentNodeCopy = new GraphNode(currentNode.key);
                nodeMapping.put(currentNode, currentNodeCopy);
                while (toExpandNodes.size() != 0) {
                    GraphNode toExpandNode = toExpandNodes.poll();
                    if (expanded.contains(toExpandNode)) {
                        continue;
                    }

                    GraphNode toExpandNodeCopy = new GraphNode(toExpandNode.key);
                    nodeMapping.put(toExpandNode, toExpandNodeCopy);
                    expanded.add(toExpandNode);
                    toExpandNodes.offer(toExpandNode);
                    for (GraphNode neighbor : toExpandNode.neighbors) {
                        if (!nodeMapping.containsKey(neighbor)) {
                            GraphNode neighborCopy = new GraphNode(neighbor.key);
                            nodeMapping.put(neighbor, neighborCopy);
                        }
                        toExpandNodes.offer(neighbor);
                        toExpandNodeCopy.neighbors.add(nodeMapping.get(neighbor));
                    }
                }
                copiedGraph.add(nodeMapping.get(currentNode));
            }
        }
        return copiedGraph;
    }


    //DFS 的写法
    public List<GraphNode> copy1(List<GraphNode> graph) {
        Map<GraphNode, GraphNode> nodeMapping = new HashMap<>();
        List<GraphNode> copyGraph = new ArrayList<>();
        for (GraphNode currentNode: graph) {
            copyGraph.add(cloneGraph(currentNode, nodeMapping));
        }
        return copyGraph;
    }

    private GraphNode cloneGraph(GraphNode current, Map<GraphNode, GraphNode> nodeMapping) {
        if (current == null) {
            return null;
        }
        if (nodeMapping.containsKey(current)) {
            return nodeMapping.get(current);
        }

        GraphNode copiedNode = new GraphNode(current.key);
        nodeMapping.put(current, copiedNode);
        for (GraphNode neighbor : current.neighbors) {
            copiedNode.neighbors.add(cloneGraph(neighbor, nodeMapping));
        }
        return copiedNode;
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
