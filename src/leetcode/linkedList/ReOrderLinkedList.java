package leetcode.linkedList;

import java.util.LinkedList;

public class ReOrderLinkedList {

    private static ListNode reOrderLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

       ListNode fast = head;
       ListNode slow = head;
       //find the middle point of the LinkedList
        //bug fast.next.next != null!!!!!
       while (fast.next != null && fast.next.next != null) {
           fast = fast.next.next;
           slow = slow.next;
       }

       //reverse LinkedList
       ListNode tail = reverse(slow.next);
       slow.next = null;

       //merge leetcode.linkedList
       ListNode current = head;
       //!!!bug 用tail来控制循环，因为用head控制的话 单双数会出现不同的情况
       while (tail != null) {
           ListNode tempTailNext = tail.next;
           tail.next = current.next;
           current.next = tail;
           current = tail.next;
           tail = tempTailNext;
       }
       return head;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main (String args[]) {
        LinkedList<ListNode> test = new LinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
       // ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
       // node4.next = node5;

        test.add(node1);
        test.add(node2);
        test.add(node3);
        test.add(node4);
       // test.add(node5);

        ListNode temp = reOrderLinkedList(test.getFirst());
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }
}
/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null
to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

Examples

L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null

 */
