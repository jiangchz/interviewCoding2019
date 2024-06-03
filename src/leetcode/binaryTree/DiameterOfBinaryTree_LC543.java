package leetcode.binaryTree;

public class DiameterOfBinaryTree_LC543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return getMaxLength(root).twoBranchMax - 1;
    }
    private static SubtreeMax EMPTY_NODE = new SubtreeMax(0, 0);
    private static SubtreeMax LEAF_NODE = new SubtreeMax(1, 1);

    private static SubtreeMax getMaxLength(TreeNode root) {
        if (root == null) {
            return EMPTY_NODE;
        }

        if (root.left == null && root.right == null) {
            return LEAF_NODE;
        }

        return combineSubTreeResult(getMaxLength(root.left), getMaxLength(root.right));
    }

    private static SubtreeMax combineSubTreeResult(SubtreeMax leftResult, SubtreeMax rightResult) {
        int maxWithOutRoot = Math.max(leftResult.getTwoBranchMax(), rightResult.getTwoBranchMax());
        int twoBranchMax = Math.max(maxWithOutRoot, leftResult.getSingleBranchMax() + rightResult.getSingleBranchMax() + 1);
        int singleBranchMax = Math.max(leftResult.getSingleBranchMax(), rightResult.getSingleBranchMax()) + 1;
        return new SubtreeMax(twoBranchMax, singleBranchMax);
    }

    private static class SubtreeMax {
        private int twoBranchMax;
        private int singleBranchMax;

        public SubtreeMax(int twoBranchMax, int singleBranchMax) {
            this.twoBranchMax = twoBranchMax;
            this.singleBranchMax = singleBranchMax;
        }

        public int getTwoBranchMax() {
            return this.twoBranchMax;
        }

        public int getSingleBranchMax() {
            return this.singleBranchMax;
        }

    }
}
/*

1181. Diameter of Binary Tree
中文English
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

样例
Example 1:

Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input:[2,3,#,1]
Output:2

Explanation:
      2
    /
   3
 /
1
 */