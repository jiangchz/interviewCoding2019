package leetcode.linkedList;

public class MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        } else if (two == null) {
            return one;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                current.next = one;
                one = one.next;
            } else {
                current.next = two;
                two = two.next;
            }
            // forget to update current pointer!
            current = current.next;
        }


        current.next =  one == null ? two : one;
        return dummy.next;
    }
}
