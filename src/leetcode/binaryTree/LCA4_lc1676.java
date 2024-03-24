package leetcode.binaryTree;

import java.util.Set;

public class LCA4_lc1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> nodeSet = Set.of(nodes);

        return lcaHelper(root, nodeSet);
    }

    private TreeNode lcaHelper(TreeNode root, Set<TreeNode> nodes) {
        if (root == null) {
            return root;
        }

        TreeNode left = lcaHelper(root.left, nodes);
        TreeNode right = lcaHelper(root.right, nodes);

        if (nodes.contains(root)) {
            return root;
        } else if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
