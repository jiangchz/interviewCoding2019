package leetcode.hashMap;

import java.util.*;

public class LFUCache {

    private int capacity;
    private Map<Integer, Node> items;
    private TreeMap<Node, Integer> frequents;
    public LFUCache(int capacity){
        capacity = capacity;
        items = new HashMap<>(capacity);
        frequents = new TreeMap<>((node1, node2) -> {
            if(node1.count > node2.count) {
                return 1;
            }
                return -1;
        });
    }

    public int get(int key) {
        if (!items.containsKey(key)) {
            return -1;
        }
        Node currentNode = items.get(key);
        Node newNode = new Node(currentNode.count + 1, currentNode.value);
        items.put(key, newNode);
        frequents.put(newNode, frequents.get(currentNode) + 1);
        frequents.remove(currentNode);
        return newNode.value;
    }

    private static class Node {
        public int count;
        public int value;
        public Node(int count, int value) {
            this.count = count;
            this.value = value;
        }
    }
}