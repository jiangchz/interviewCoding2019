package leetcode.linkedList;

public class MiddleNodeOfLinkedList {
    public static ListNode getMiddleNodeOfListedList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
           fast = fast.next.next;
           slow = slow.next;
        }
        return slow;
    }
}
