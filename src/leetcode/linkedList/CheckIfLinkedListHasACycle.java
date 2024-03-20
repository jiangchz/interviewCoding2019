package leetcode.linkedList;

public class CheckIfLinkedListHasACycle {
    public static boolean getMiddleNodeOfListedList(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
           fast = fast.next.next;
           slow = slow.next;
           if (slow == fast) {
               return true;
           }
        }
        return false;
    }
}
