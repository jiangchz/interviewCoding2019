package leetcode.twoPointers;
public class DuplicateNumber {
    /**
     * @param nums an leetcode.array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1)
            return -1;

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
/*
要做这个题你首先需要去做一下 Linked List Cycle 这个题。
如果把数据看做一个 LinkedList，第 i 个位置上的值代表第 i 个点的下一个点是什么的话，我们就能画出一个从 0 出发的，一共有 n + 1 个点的 Linked List。
可以证明的一件事情是，这个 Linked List 一定存在环。因为无环的 Linked List 里 非空next 的数目和节点的数目关系是差一个（节点多，非空next少）

那么，我们证明了这是一个带环链表。而我们要找的重复的数，也就是两个点都指向了同一个点作为 next 的那个点。也就是环的入口。

因此完全套用 Linked List Cycle 这个题快慢指针的方法即可。

什么是快慢指针算法？
从起点出发，慢指针走一步，快指针走两步。因为有环，所以一定会相遇。
相遇之后，把其中一根指针拉回起点，重新走，这回快慢指针都各走一步。他们仍然会再次相遇，且相遇点为环的入口。

时间复杂度是多少？
时间复杂度是 O(n)O(n) 的。
 */