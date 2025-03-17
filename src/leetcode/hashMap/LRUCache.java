package leetcode.hashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return this.size() > capacity;
    }
}

class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity; 
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node current = map.get(key);
        remove(current);
        append(current);
        return current.value;
    }

    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node current = map.get(key);
            remove(current);
            append(current);
            current.value = value;
        } else if (map.size() == capacity) {
            Node current = tail;
            remove(current);
            append(new Node(key, value));
        } else {
            append(new Node(key, value));
        }
    }

     private void remove(Node current){
        map.remove(current.key);
        if (current.pre != null) {
            current.pre.next = current.next;
        }

        if (current.next != null) {
            current.next.pre = current.pre;
        }

        if (current == head) {
            head = head.next;
        }
        if (current == tail) {
            tail = tail.pre;
        }
        current.next = current.pre = null;
    }

    private void append(Node current) {
        map.put(current.key, current);
        if (head == null) {
            head = current;
            tail = current;
        } else {
            current.next = head;
            head.pre = current;
            head = current;
        }
    }

    private static class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

