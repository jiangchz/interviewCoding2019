package leetcode.binaryTree;

import org.w3c.dom.Node;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList_LC426 {
    class Solution {
        public TreeNode treeToDoublyList(TreeNode root) {
            if (root == null) {
                return root;
            }

            TreeNode res[] = helper(root);
            res[0].left = res[1];
            res[1].right = res[0];
            return res[0];
        }

        private TreeNode[] helper(TreeNode current) {
            if (current == null) {
                return null;
            }

            TreeNode[] leftRes = helper(current.left);
            TreeNode[] rightRes = helper(current.right);

            TreeNode[] res = new TreeNode[] {current, current};
            if (leftRes == null && rightRes == null) {
                return new TreeNode[] {current, current};
            }

            if (leftRes != null) {
                current.left = leftRes[1];
                leftRes[1].right = current;
                res[0] = leftRes[0];
            }

            if (rightRes != null) {
                current.right = rightRes[0];
                rightRes[0].left = current;
                res[1] = rightRes[1];
            }

            return res;
        }
    }
}


/**
 *
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [4,2,5,1,3]
 *
 *
 * Output: [1,2,3,4,5]
 *
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 *
 * Example 2:
 *
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 */