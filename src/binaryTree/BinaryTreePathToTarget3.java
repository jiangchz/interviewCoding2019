package binaryTree;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreePathToTarget3 {
    public boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSum = new HashSet<>();
        prefixSum.add(0); // bug2
        return helper(root, target, prefixSum, 0);
    }
    private boolean helper(TreeNode root, int target, Set<Integer> prefixSum, int currentSum) {
        currentSum += root.key;
        if (prefixSum.contains(currentSum - target)) {
            return true;
        }                                              //bug3 2者的顺序
        boolean needRemove = prefixSum.add(currentSum);//bug1

        if (root.left != null && helper(root.left, target, prefixSum, currentSum)) {
            return true;
        } else if (root.right != null && helper(root.right, target, prefixSum, currentSum)) {
            return true;
        }
        if (needRemove) {
            prefixSum.remove(currentSum);//bug4
        }
        return false;
    }
}

/*
Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.

Examples

    5

  /    \

2      11

     /    \

    6     14

  /

 3

If target = 17, There exists a path 11 + 6, the sum of the path is target.

If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

If target = 10, There does not exist any paths sum of which is target.

If target = 11, There exists a path only containing the node 11.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */