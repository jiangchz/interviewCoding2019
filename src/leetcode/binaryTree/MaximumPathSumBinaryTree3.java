package leetcode.binaryTree;

//(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes,
//and the subpath is allowed to contain only one node).
//从跟节点到叶子节点的一条路径上的最大路径和
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
        //如果叶子节点下面的返回值为负数的话，把下面节点的值扔掉
        int pathSum = maxChildSum > 0 ? maxChildSum + root.key : root.key;
        currentMax[0] = Math.max(pathSum, currentMax[0]);
        return pathSum;
    }


    //在递归函数里面不断的更新结果
    public int maxPathSum1(TreeNode root) {
        int[] maxSum = new int[1];
        maxPathSumHelper1(root, maxSum, 0);
        return maxSum[0];
    }


    //version1 从总的根节点到某个叶子节点
    private void maxPathSumHelper1(TreeNode root,
                                  int[] maxSum,
                                  int currentPathSum) {
        if (root == null) {
            return;
        }

        currentPathSum += root.key;
        if (root.left == null && root.right == null) {
            maxSum[0] = Math.max(currentPathSum, maxSum[0]);
        }
        maxPathSumHelper1(root.left, maxSum, currentPathSum);
        maxPathSumHelper1(root.right, maxSum, currentPathSum);
    }

    //version 2 整个树的根节点到去叶子节点路径上的某个点的最大路径值
    private void maxPathSumHelper2(TreeNode root,
                                  int[] maxSum,
                                  int currentPathSum) {
        if (root == null) {
            return;
        }

        currentPathSum += root.key;
        maxSum[0] = Math.max(currentPathSum, maxSum[0]);
        maxPathSumHelper2(root.left, maxSum, currentPathSum);
        maxPathSumHelper2(root.right, maxSum, currentPathSum);
    }

    //version 2 某个子树的根节点到某个叶子节点路径上的最大值
    private void maxPathSumHelper3(TreeNode root,
                                   int[] maxSum,
                                   int currentPathSum) {
        if (root == null) {
            return;
        }

        currentPathSum = currentPathSum > 0 ? (currentPathSum + root.key) : root.key;
        maxSum[0] = Math.max(currentPathSum, maxSum[0]);
        maxPathSumHelper3(root.left, maxSum, currentPathSum);
        maxPathSumHelper3(root.right, maxSum, currentPathSum);
    }
}
