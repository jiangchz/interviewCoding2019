package leetcode.binaryTree;

public class LCA2_lc1644 {
    //one 和 two 不一定在树上的变种
    boolean foundP = false;
    boolean foundQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = lcaHelper(root, p, q);
        return foundP && foundQ ? result : null;
    }

    public TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        TreeNode left = lcaHelper(root.left, p, q);
        TreeNode right = lcaHelper(root.right, p, q);

        if (root == p) {
            foundP = true;
            return root;
        }

        if (root == q) {
            foundQ = true;
            return root;
        }

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }

    }
}
