package linkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKLinkedList {
    public ListNode merge(List<ListNode> listOfLists) {
        if (listOfLists == null || listOfLists.size() == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(listOfLists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.value - node2.value;
            }
        });
        for (ListNode current : listOfLists) {
            if (current != null) {
                minHeap.offer(current);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while (minHeap.size() != 0) {
            current.next =  minHeap.poll();
            current = current.next;
            if (current.next != null) {
                minHeap.offer(current.next);
            }
        }
        return dummyHead.next;
    }
}
