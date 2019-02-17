package BinaryTree;

public class IsBST {
    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int currentMax = Integer.MAX_VALUE;
        int currentMin = Integer.MIN_VALUE;
        return isBSTHelper(root.left, currentMin, root.key) && isBSTHelper(root.right, root.key, currentMax);
    }

    private boolean isBSTHelper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

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