package binaryTree;

//any node to any node
public class MaximumPathSumBinaryTree2 {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{root.key};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }
    private int maxPathSumHelper(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int leftPathSum = maxPathSumHelper(root.left, maxSum);
        int rightPathSum = maxPathSumHelper(root.right, maxSum);

        leftPathSum = Math.max(0, leftPathSum);
        rightPathSum = Math.max(0, rightPathSum);
        int crossSum = leftPathSum + rightPathSum + root.key;
        maxSum[0] = Math.max(crossSum, maxSum[0]);
        return root.key + Math.max(leftPathSum, rightPathSum);
    }
}
