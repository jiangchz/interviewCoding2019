package leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class ListNode {
        ListNode next;
        ListNode previous;
        int value;
        int key;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, ListNode> map;
    //1. 不需要新建一个list
    //2. 直接建head 和tail 指向-1
    private ListNode head = new ListNode(-1, -1);;
    private ListNode tail = new ListNode(-1, -1);;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        tail.previous = head;
        head.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            removeNodeFromList(key);
            moveToHead(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //精妙，通过get做完了move to head的操作
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        ListNode current = new ListNode(key, value);
        map.put(key, current);
        moveToHead(key);

        if (map.size() > capacity) {
            removeTail();
        }
    }

    private void moveToHead(int key) {
        //add current node to head
        //bug need to ensure four links linked
        ListNode current = map.get(key);
        current.next = head.next;
        head.next.previous = current;
        head.next = current;
        current.previous = head;
    }

    private void removeNodeFromList(int key) {
        //remove current
        ListNode current = map.get(key);
        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    private void removeTail() {
        map.remove(tail.previous.key);
        tail.previous = tail.previous.previous;
        tail.previous.next = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */