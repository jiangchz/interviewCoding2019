package leetcode.linkedList;

public class InsertIntoASortedCircularLinkedList_LC708 {
    public ListNode InsertIntoASortedCircularLinkedList(ListNode head, int insertVal) {
        ListNode node = new ListNode(insertVal);

        if (head == null) {
            node.next = node;
            return node;
        }

        ListNode pre = head;
        ListNode next = head.next;

        while (next != head) {
            int nextVal = next.value;
            int preVal = pre.value;
            if ((preVal <= insertVal && insertVal < nextVal) //e.g 3-> (2/1) -> 1
                    || (insertVal >= preVal && preVal > nextVal)// e.g (3/2) -> 2 -> 1
                    || (preVal > nextVal && nextVal >= insertVal)) { // e.g [4 -> 5-> 6-> (2) -> 3 ]
                break;
            }
            pre = next;
            next = next.next;
        }

        pre.next = node;
        node.next = next;
        return head;
    }
}

/**
 *
 * Given a Circular Linked List node, which is sorted in non-descending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list and may not necessarily be the smallest value in the circular list.
 *
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.
 *
 * If the list is empty (i.e., the given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the originally given node.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 * Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.
 *
 *
 *
 * Example 2:
 *
 * Input: head = [], insertVal = 1
 * Output: [1]
 * Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to that single node.
 * Example 3:
 *
 * Input: head = [1], insertVal = 0
 * Output: [1,0]
 */