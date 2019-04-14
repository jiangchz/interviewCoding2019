package binaryTree;

public class IsBST {
    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBSTHelper(root.left, null, null);
    }

    private boolean isBSTHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        //if ((gobalMax != null && root.val >= gobalMax) || (gobalMin != null && root.val <= gobalMin )) {
        if (root.key >= min || root.key <= max) {
            return false;
        }
        return isBSTHelper(root.left, min, root.key) && isBSTHelper(root.right, root.key, max);
    }
}


/*
 binary search tree: for each node, it's greater than all the left-subtree nodes and
 smaller than all the right sub-tree nodes

 bug:

  if (root.key > min || root.key < max) {
            return false;
        }

   should be >=  <=

 */