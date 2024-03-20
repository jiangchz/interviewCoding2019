package leetcode.linkedList;

import java.util.LinkedList;

public class PartitionLinkedList {

    private static ListNode partitionLinkedList(ListNode head, int target) {
       ListNode lowHead = new ListNode(0);
       ListNode highHead = new ListNode(0);
       ListNode currentLow = lowHead;
       ListNode currentHigh = highHead;

       //split LinkedList to high and low sub-lists
       while (head != null) {
           if (head.value > target) {
               currentHigh.next = head;
               currentHigh = currentHigh.next;
           } else {
               currentLow.next = head;
               currentLow = currentLow.next;
           }
           head = head.next;
       }

        currentLow.next = highHead.next;
       //! bug, 忘记把highlist的最后一个pointer设为空，有环
        currentHigh.next = null;
        return lowHead.next;
    }
    public static void main (String args[]) {
        LinkedList<ListNode> test = new LinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        test.add(node1);
        test.add(node2);
        test.add(node3);
        ListNode temp = partitionLinkedList(test.getFirst(), 4);
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }
}
/*
Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes
larger than or equal to target value T.
The original relative order of the nodes in each of the two partitions should be preserved.

Examples

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null

 */
