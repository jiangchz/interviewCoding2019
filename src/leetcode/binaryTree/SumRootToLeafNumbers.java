package leetcode.binaryTree;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumberHelper(root, 0);
    }

    private int sumNumberHelper(TreeNode root, int prefix) {
        if (root == null) {
            return 0;
        }
        prefix = root.key + prefix * 10;
        int left = sumNumberHelper(root.left, prefix);
        int right = sumNumberHelper(root.right, prefix);

        if (left == 0 && right == 0) {
            return prefix;
        } else {
            return left + right;
        }
    }
}
