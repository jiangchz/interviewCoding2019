package leetcode.binaryTree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestor3 {
    //变种1： 最小公共祖先of k nodes，确定一定能找到
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> nodeSet = new HashSet<>();
        nodeSet.addAll(nodes);
        return lcaHelper(root, nodeSet);
    }

    private TreeNode lcaHelper(TreeNode root, Set<TreeNode> nodeSet) {
        if (root == null || nodeSet.contains(root)) {
            return root;
        }
        TreeNode left = lcaHelper(root.left, nodeSet);
        TreeNode right = lcaHelper(root.right, nodeSet);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
    }

    private static TreeNode createTree() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;
//        treeNode4.right = treeNode8;
        return treeNode1;

    }

}
