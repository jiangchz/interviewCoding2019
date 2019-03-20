package binaryTree;

//(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes,
//and the subpath is allowed to contain only one node).
public class MaximumPathSumBinaryTree3 {
    public int maxPathSum(TreeNode root) {
        int[] currentMax = new int[]{root.key};
        maxPathSumHelper(root, currentMax);
        return currentMax[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] currentMax) {
        if (root == null) {
            return 0;
        }
        int maxChildSum = Math.max(maxPathSumHelper(root.left, currentMax),
                maxPathSumHelper(root.right, currentMax));
        int pathSum = maxChildSum > 0 ? maxChildSum + root.key : root.key;
        currentMax[0] = Math.max(pathSum, currentMax[0]);
        return pathSum;
    }
}
