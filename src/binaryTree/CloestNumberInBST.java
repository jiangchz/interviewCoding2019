package binaryTree;

public class CloestNumberInBST {
    public int largestSmaller(TreeNode root, int target) {
        int result[] = new int[] {Integer.MIN_VALUE};
        largestSmallerHelper(root, target, result);
        return result[0];
    }
    private void largestSmallerHelper(TreeNode root, int target, int[] result) {
        if (root == null) {
            return;
        }
        int current = root.key;
        if (current >= target) {
            largestSmallerHelper(root.left, target, result);
        } else {
            result[0] = Math.max(current, result[0]);
            largestSmallerHelper(root.right, target, result);
        }
    }
}
