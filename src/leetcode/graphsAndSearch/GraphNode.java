package leetcode.graphsAndSearch;

import java.util.ArrayList;

public class GraphNode {
    public int value;
    public char color;
    public ArrayList<GraphNode> neighbors;
    //todo update with builder pattern
    public GraphNode(int value) {
        this(value, 'c', null);
    }
    public GraphNode(int value, ArrayList<GraphNode> neighbors) {
       this(value, 'c', neighbors);
    }
    public GraphNode(int value, char color, ArrayList<GraphNode> neighbors) {
        this.value = value;
        this.color = color;
        this.neighbors = neighbors;
    }
}