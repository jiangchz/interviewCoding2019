package linkedList;

import java.util.LinkedList;

public class ReverseLinkedListRecursive {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        //todo
        return null;
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
        ListNode temp = reverse(test.getFirst());
        while (temp.next != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }
}
