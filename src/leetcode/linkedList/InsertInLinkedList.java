package leetcode.linkedList;

import java.util.LinkedList;

public class InsertInLinkedList {
    public static ListNode insert(ListNode head, int value) {
        ListNode nodeToAdd = new ListNode(value);
        if (head == null) {
            return nodeToAdd;
        }

        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;
        ListNode  current = dummyNode;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            if (current.value < value && (next == null || next.value >= value)) {
                insertAfter(current, nodeToAdd);
                break;
            }
            current = current.next;

        }
        return dummyNode.next;
    }

    private static void insertAfter(ListNode current, ListNode nodeToAdd) {
        ListNode next = current.next;
        current.next = nodeToAdd;
        nodeToAdd.next = next;
    }

    public static void main (String args[]) {
        LinkedList<ListNode> test = new LinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        test.add(node1);
        test.add(node2);
        test.add(node3);
        ListNode temp = insert(test.getFirst(), 2);
        while (temp.next != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }
}
