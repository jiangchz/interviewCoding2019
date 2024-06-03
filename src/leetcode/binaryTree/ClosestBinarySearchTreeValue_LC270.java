package leetcode.binaryTree;

public class ClosestBinarySearchTreeValue_LC270 {
    public int closestValue(TreeNode root, double target) {
        if (root.key == target) {
            return root.key;
        }

        int res = root.key;
        if (root.key > target && root.left != null) {
            res = closestValue(root.left, target);
        } else if (root.key < target && root.right != null) {
            res = closestValue(root.right, target);
        }

        if (Math.abs(target - res) == Math.abs(target - root.key)) {
            return res > root.key ? root.key : res;
        } else {
            return Math.abs(target - res) > Math.abs(target - root.key) ? root.key : res;
        }

    }
}

/**
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.
 * Example 1:
 *
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 * Output: 4
 * Example 2:
 *
 * Input: root = [1], target = 4.428571
 * Output: 1
 */