package leetcode.linkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLinkedList_LC23 {
    public ListNode merge(List<ListNode> listOfLists) {
        if (listOfLists == null || listOfLists.size() == 0) {
            return null;

        }

        //Enqueue first node of each list
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(listOfLists.size(), Comparator.comparingInt(node -> node.value));
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
