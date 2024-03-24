package leetcode.binaryTree;

public class LowestCommonAncestor1_LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        //leaf node
        if (root == null) {
            return null;
        }

        //pruning in advance， say we get root == one, we don't need to check if we able to find two in current subtree
        //**we will check if two in the other half of the tree**
        if (root == one || root == two) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
