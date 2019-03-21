package linkedList;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        if(head == null) {
            return head;
        }

        Map<RandomListNode, RandomListNode> nodeMapping = new HashMap<>();
        RandomListNode current = head;
        RandomListNode previous = null;
        while (current != null) {
            RandomListNode newNode = new RandomListNode(current.value);
            nodeMapping.put(current, newNode);
            if (previous != null) {
                previous.next = newNode;
            }
            previous = newNode;
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                nodeMapping.get(current).random = nodeMapping.get(current.random);
            }
            current = current.next;
        }
        return nodeMapping.get(head);
    }
}
